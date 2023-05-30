package template.default.tables

import com.lowagie.text.pdf.PdfPTable
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableSummary(private val cvUtil: CvUtil)
{
    companion object
    {
        const val COLUMNS = 1
    }

    fun getTable(
        title: String,
        summary: String,
        since: String,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
        textSizeSummary: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val baseFontTitle = cvUtil.getFont()
            .getTimes()
        val font = cvUtil.getFont()
            .getSource()
        val fontBold = cvUtil.getFont()
            .getSourceBold()
        val tableUtil = cvUtil.getTable()

        val cellSpace = tableUtil.getCell(
            tableUtil.getParagraph(
                " ",
                baseFontTitle,
                textSizeTitle
            ),
            fixLeading = CvTableUtil.FIXED_LEADING_MEDIUM
        )

        val cellTitle = tableUtil.getCell(
            tableUtil.getParagraph(
                title,
                baseFontTitle,
                textSizeTitle
            ),
            colSpan = 1
        )

        val cellSummary = tableUtil.getCell(
            tableUtil.getParagraph(
                summary,
                font,
                fontBold,
                textSizeSummary
            ),
            colSpan = 1
        )

        //val cellSince = tableUtil.getCell(tableUtil.getParagraph(since, font, fontBold, textSizeSummary), colSpan = 1)

        val table = tableUtil.getTable(columns = COLUMNS)
        table.addCell(cellSpace)
        table.addCell(cellTitle)
        table.addCell(cellSummary)
        //table.addCell(cellSince)

        return table
    }
}