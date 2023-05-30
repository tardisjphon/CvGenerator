package utils.cv

import com.lowagie.text.*
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import java.awt.Color


class CvTableUtil(private val cvTagsUtil: CvTagsUtil)
{
    companion object
    {
        const val NAME_TEXT_SIZE = 20f
        const val TITLE_TEXT_SIZE = 15f
        const val COMPANY_TEXT_SIZE = 13f
        const val COMMON_TEXT_SIZE = 9f

        const val TABLE_WIDTH_PERCENTAGE = 85f
        const val FIXED_LEADING_SMALL = 10.5f
        const val FIXED_LEADING = 14.5f
        const val FIXED_LEADING_MEDIUM = 15f //15f
        const val FIXED_LEADING_BIG = 25f
    }

    fun getTable(
        columns: Int,
        widths: FloatArray? = null,
        width: Float? = null
    ): PdfPTable
    {
        val table = PdfPTable(columns)
        table.isLockedWidth = false
        table.widthPercentage = width ?: TABLE_WIDTH_PERCENTAGE
        widths?.let { table.setWidths(widths) }
        return table
    }

    fun getParagraph(
        text: String,
        baseFont: BaseFont,
        textSize: Float
    ): Paragraph
    {
        return getParagraph(
            text,
            Font(
                baseFont,
                textSize,
                Font.NORMAL
            ),
            Font(
                baseFont,
                textSize,
                Font.BOLD
            )
        )
    }

    fun getParagraph(
        text: String?,
        fontNormal: Font,
        fontBold: Font,
        textSize: Float
    ): Paragraph
    {
        fontNormal.size = textSize
        fontBold.size = textSize

        return getParagraph(
            text,
            fontNormal,
            fontBold
        )
    }

    private fun getParagraph(
        text: String?,
        fontNormal: Font,
        fontBold: Font
    ): Paragraph
    {
        val paragraph = Paragraph()
        if (text.isNullOrBlank()) return paragraph

        val pairBold = cvTagsUtil.getPairWithBold(text)
        val bodedText = pairBold.second
        if (bodedText.isNotBlank())
        {
            val normalText = pairBold.first
            val phrase1 = Phrase(
                0f,
                normalText,
                fontNormal
            )
            val phrase2 = Phrase(
                0f,
                bodedText,
                fontBold
            )
            if (text.indexOf(bodedText) > text.indexOf(normalText))
            {
                paragraph.add(phrase1)
                paragraph.add(phrase2)
            }
            else
            {
                paragraph.add(phrase2)
                paragraph.add(phrase1)
            }
        }
        else
        {
            val phrase = Phrase(
                0f,
                text,
                fontNormal
            )
            paragraph.add(phrase)
        }
        return paragraph
    }

    fun getParagraphWithAnchor(
        text: String,
        font: Font,
        textSize: Float
    ): Paragraph
    {
        font.size = textSize
        val psAnchor = Anchor(
            text,
            font
        )
        psAnchor.name = text
        psAnchor.reference = "https://${cvTagsUtil.removeNotLinkChars(text)}"
        val paragraph = Paragraph()
        paragraph.add(psAnchor)
        return paragraph
    }

    fun getCell(
        text: String,
        baseFont: BaseFont,
        textSize: Float,
        colSpan: Int? = null,
        fixLeading: Float = FIXED_LEADING
    ): PdfPCell
    {
        return getCell(
            getParagraph(
                text,
                baseFont,
                textSize
            ),
            colSpan = colSpan,
            fixLeading = fixLeading
        )
    }

    fun getCell(
        paragraph: Paragraph,
        colSpan: Int? = null,
        fixLeading: Float = FIXED_LEADING,
        isVisible: Boolean = false
    ): PdfPCell
    {
        val cell = PdfPCell(paragraph)
        cellPrepare(
            cell,
            colSpan,
            fixLeading,
            isVisible
        )
        return cell
    }

    fun getCell(
        image: Image,
        colSpan: Int? = null,
        fixLeading: Float = FIXED_LEADING,
        isVisible: Boolean = false
    ): PdfPCell
    {
        val cell = PdfPCell(image)
        cellPrepare(
            cell,
            colSpan,
            fixLeading,
            isVisible
        )
        return cell
    }

    fun getCell(
        table: PdfPTable,
        colSpan: Int? = null,
        fixLeading: Float = FIXED_LEADING,
        isVisible: Boolean = false
    ): PdfPCell
    {
        val cell = PdfPCell(table)
        cellPrepare(
            cell,
            colSpan,
            fixLeading,
            isVisible
        )
        return cell
    }

    private fun cellPrepare(
        cell: PdfPCell,
        colSpan: Int? = null,
        fixLeading: Float = FIXED_LEADING,
        isVisible: Boolean = false
    )
    {
        colSpan?.let { cell.colspan = colSpan }
        cell.setLeading(
            fixLeading,
            0f
        )
        setCellBorderVisibility(
            cell,
            isVisible
        )
    }

    private fun setCellBorderVisibility(
        cell: PdfPCell,
        isVisible: Boolean = false
    )
    {
        //val dark = 0
        val darkGrey = 169
        val color = darkGrey
        cell.borderColor = Color(
            color,
            color,
            color
        )
        cell.borderWidth = if (isVisible) 0.05f else 0f
    }
}