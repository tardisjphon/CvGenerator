package cv

import com.lowagie.text.Document
import com.lowagie.text.ListItem
import com.lowagie.text.pdf.PdfWriter
import repository.IRepository
import repository.model.pdf.general.CvLanguage
import repository.model.pdf.properties.PdfPropertiesData
import template.default.DefaultTemplate
import utils.CvUtil
import utils.cv.CvDocumentUtil
import java.io.FileOutputStream


class Cv(
    private val repository: IRepository,
    private val cvLanguage: CvLanguage = CvLanguage.ENGLISH,
    private val pdfPropertiesData: PdfPropertiesData
) : IRepository by repository
{
    private var document: Document = Document()
    private val cvUtil by lazy { CvUtil(document) }
    private val template by lazy {
        DefaultTemplate(
            cvLanguage,
            repository.getDataModel(cvLanguage),
            document,
            cvUtil
        )
    }

    init
    {
        create()
    }

    private fun create()
    {
        val documentUtil = cvUtil.getDocument()
        val filePath = documentUtil.getFilePath(
            pdfPropertiesData.title,
            cvLanguage
        )
        val writer = getWriter(
            document,
            filePath
        )
        documentUtil.setDocumentProperties(pdfPropertiesData)
        setFooter(documentUtil)
        setContent(
            document,
            template,
            writer,
            filePath
        )
    }

    private fun setFooter(documentUtil: CvDocumentUtil)
    {
        documentUtil.setPageNumberFooter(
            documentUtil.getPageText(cvLanguage),
            pdfPropertiesData.footerImagePath
        )
    }

    private fun setContent(
        document: Document,
        template: DefaultTemplate,
        writer: PdfWriter,
        filePath: String
    )
    {
        try
        {
            document.open()
            template.setPdfContent()
            if (writer.isPageEmpty)
            {
                document.add(ListItem("please add the content :)"))
            }
            writer.directContent.sanityCheck()
            document.close()

            println("finished in folder: $filePath")
        }
        catch (ex: Exception)
        {
            println("exception: ${ex.message}")
        }
    }

    private fun getWriter(
        document: Document,
        filePath: String
    ): PdfWriter
    {
        return PdfWriter.getInstance(
            document,
            FileOutputStream(filePath)
        )
    }
}