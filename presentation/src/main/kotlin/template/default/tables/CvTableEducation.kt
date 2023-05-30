package template.default.tables

import com.lowagie.text.pdf.PdfPTable
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableEducation(private val cvUtil: CvUtil)
{
    companion object
    {
        const val COLUMNS = 1
    }

    fun getTable(
        title: String,
        school: String,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
        textSizeSummary: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val fontTitle = cvUtil.getFont()
            .getTimes()
        val font = cvUtil.getFont()
            .getSource()
        val fontBold = cvUtil.getFont()
            .getSourceBold()
        val tableUtil = cvUtil.getTable()

        val cellSpace = tableUtil.getCell(
            " ",
            fontTitle,
            textSizeTitle,
            fixLeading = CvTableUtil.FIXED_LEADING_MEDIUM
        )
        val cellTitle = tableUtil.getCell(
            title,
            fontTitle,
            textSizeTitle,
            colSpan = 1,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )
        val cellSchool = tableUtil.getCell(
            tableUtil.getParagraph(
                school,
                font,
                fontBold,
                textSizeSummary
            ),
            colSpan = 1
        )

        val table = tableUtil.getTable(columns = COLUMNS)
        table.addCell(cellSpace)
        table.addCell(cellTitle)
        table.addCell(cellSchool)

        return table
    }
}