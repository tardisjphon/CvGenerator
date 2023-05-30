package template.default.tables

import com.lowagie.text.pdf.PdfPTable
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableFocusAndRoles(private val cvUtil: CvUtil)
{
    companion object
    {
        const val COLUMNS = 2
    }

    fun getTable(
        titleFocus: String,
        titleRoles: String,
        dataFocus: String,
        dataRoles: String,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
        textSizeData: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val fontUtil = cvUtil.getFont()
        val baseFontTitle = fontUtil.getTimes()
        val fontData = fontUtil.getSource()
        val tableUtil = cvUtil.getTable()

        val cellSpace = tableUtil.getCell(
            tableUtil.getParagraph(
                " ",
                baseFontTitle,
                textSizeTitle
            ),
            fixLeading = CvTableUtil.FIXED_LEADING_MEDIUM
        )

        val table = tableUtil.getTable(columns = COLUMNS)

        table.addCell(cellSpace)
        table.addCell(cellSpace)

        if (titleFocus.isNotEmpty())
        {
            val titleFocusCell = tableUtil.getCell(
                tableUtil.getParagraph(
                    titleFocus,
                    baseFontTitle,
                    textSizeTitle
                ),
                colSpan = 1,
                fixLeading = CvTableUtil.FIXED_LEADING_BIG
            )
            table.addCell(titleFocusCell)

            if (titleRoles.isEmpty())
            {
                table.addCell(cellSpace)
            }
        }

        if (titleRoles.isNotEmpty())
        {
            val titleRolesCell = tableUtil.getCell(
                tableUtil.getParagraph(
                    titleRoles,
                    baseFontTitle,
                    textSizeTitle
                ),
                colSpan = 1,
                fixLeading = CvTableUtil.FIXED_LEADING_BIG
            )
            table.addCell(titleRolesCell)

            if (titleFocus.isEmpty())
            {
                table.addCell(cellSpace)
            }
        }

        if (dataFocus.isNotEmpty())
        {
            val dataFocusCell = tableUtil.getCell(
                tableUtil.getParagraph(
                    dataFocus,
                    fontData,
                    fontData,
                    textSizeData
                ),
                colSpan = 1
            )
            table.addCell(dataFocusCell)

            if (dataRoles.isEmpty())
            {
                table.addCell(cellSpace)
            }
        }

        if (dataRoles.isNotEmpty())
        {
            val dataRolesCell = tableUtil.getCell(
                tableUtil.getParagraph(
                    dataRoles,
                    fontData,
                    fontData,
                    textSizeData
                ),
                colSpan = 1
            )
            table.addCell(dataRolesCell)

            if (dataFocus.isEmpty())
            {
                table.addCell(cellSpace)
            }
        }

        return table
    }
}