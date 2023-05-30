package utils.cv

import com.lowagie.text.*
import repository.model.pdf.general.CvLanguage
import repository.model.pdf.properties.PdfPropertiesData
import template.default.tables.CvTableHeader
import utils.CvUtil
import java.awt.Color


class CvDocumentUtil(
    private val document: Document,
    private val cvUtil: CvUtil
)
{
    fun getPageText(cvLanguage: CvLanguage): String
    {
        return if (cvLanguage == CvLanguage.POLISH) "strona " else "page "
    }

    fun getFilePath(
        title: String,
        cvLanguage: CvLanguage
    ): String
    {
        return "pdf/" + getFileName(
            title,
            cvLanguage
        )
    }

    private fun getFileName(
        title: String,
        cvLanguage: CvLanguage
    ): String
    {
        return "$title " + cvLanguage.name.substring(
            0,
            3
        ) + ".pdf"
    }

    fun setDocumentProperties(pdfPropertiesData: PdfPropertiesData)
    {
        document.addTitle(pdfPropertiesData.title)
        document.addSubject(pdfPropertiesData.subject)
        document.addAuthor(pdfPropertiesData.author)
        document.addCreator(pdfPropertiesData.creator)
        document.addCreationDate()
    }

    fun setPageNumberFooter(
        pageText: String,
        specialContentImagePath: String,
        fontSize: Float = 8f,
        colorIn: Color = Color(
            140,
            140,
            140
        ),
        borderWidth: Float = 0f
    )
    {
        val font = cvUtil.getFont()
            .getSans()
        font.size = fontSize
        font.color = colorIn
        val phrase = Phrase(
            pageText,
            font
        )
        val footer = HeaderFooter(
            phrase,
            true
        )
        footer.setAlignment(Element.ALIGN_CENTER)
        footer.borderWidth = borderWidth

        if (specialContentImagePath.isNotEmpty())
        {
            getSpecialContent(specialContentImagePath).let {
                footer.addSpecialContent(it)
            }
        }

        document.setFooter(footer)
    }

    private fun getSpecialContent(
        specialContentImagePath: String,
        xOffset: Int = 100,
        scalePercent: Float = 35f
    ): Element?
    {
        return try
        {
            val image = Image.getInstance(specialContentImagePath)
            image.scaleToFit(
                CvTableHeader.IMAGE_SIZE,
                CvTableHeader.IMAGE_SIZE
            )
            val x = image.width + xOffset
            image.scalePercent(scalePercent)
            image.setAbsolutePosition(
                x,
                0f
            )
            image
        }
        catch (ex: Exception)
        {
            println("${ex.message}")
            null
        }
    }
}