package template.default.tables

import com.lowagie.text.pdf.PdfPTable
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableHobby(private val cvUtil: CvUtil)
{
    companion object
    {
        const val COLUMNS = 1
    }

    fun getTable(
        titleHobby: String,
        hobbies: String,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
        textSizeData: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val baseFont = cvUtil.getFont()
            .getTimes()
        val font = cvUtil.getFont()
            .getSource()
        val fontBold = cvUtil.getFont()
            .getSourceBold()
        val tableUtil = cvUtil.getTable()

        val cellSpace = tableUtil.getCell(
            tableUtil.getParagraph(
                " ",
                baseFont,
                textSizeTitle
            )
        )
        val titleHobbyCell = tableUtil.getCell(
            tableUtil.getParagraph(
                titleHobby,
                baseFont,
                textSizeTitle
            ),
            colSpan = 1,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )
        val hobbiesCell = tableUtil.getCell(
            tableUtil.getParagraph(
                hobbies,
                font,
                fontBold,
                textSizeData
            ),
            colSpan = 1
        )

        val table = tableUtil.getTable(columns = COLUMNS)
        table.addCell(cellSpace)
        table.addCell(cellSpace)

        table.addCell(titleHobbyCell)
        table.addCell(hobbiesCell)

        return table
    }
}