package template.default.tables

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableLanguageAndContact(private val cvUtil: CvUtil)
{
    companion object
    {
        const val COLUMNS = 2
    }

    fun getTable(
        titleLanguage: String,
        dataLanguage: List<repository.model.pdf.content.model.Language>,
        titleContact: String,
        dataContact: List<String>,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
        textSizeData: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val baseFontTitle = cvUtil.getFont()
            .getTimes()
        val font = cvUtil.getFont()
            .getSource()
        val fontBold = cvUtil.getFont()
            .getSourceBold()
        val tableUtil = cvUtil.getTable()

        val cellEmpty = tableUtil.getCell(
            tableUtil.getParagraph(
                "",
                baseFontTitle,
                textSizeTitle
            )
        )
        val cellSpace = tableUtil.getCell(
            tableUtil.getParagraph(
                " ",
                baseFontTitle,
                textSizeTitle
            )
        )
        val titleLanguageCell = tableUtil.getCell(
            tableUtil.getParagraph(
                titleLanguage,
                baseFontTitle,
                textSizeTitle
            ),
            colSpan = 1,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )
        val titleContactCell = tableUtil.getCell(
            tableUtil.getParagraph(
                titleContact,
                baseFontTitle,
                textSizeTitle
            ),
            colSpan = 1,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )

        val dataLanguageCells = ArrayList<PdfPCell>()
        dataLanguage.forEach {
            dataLanguageCells.add(
                tableUtil.getCell(
                    tableUtil.getParagraph(
                        it.name,
                        font,
                        fontBold,
                        textSizeData
                    ),
                    colSpan = 1,
                    fixLeading = CvTableUtil.FIXED_LEADING_SMALL
                )
            )
            dataLanguageCells.add(
                tableUtil.getCell(
                    tableUtil.getParagraph(
                        it.level,
                        font,
                        fontBold,
                        textSizeData
                    ),
                    colSpan = 1,
                    fixLeading = CvTableUtil.FIXED_LEADING_SMALL
                )
            )
        }

        val dataContactCells = ArrayList<PdfPCell>()
        dataContact.forEach {
            val paragraph = tableUtil.getParagraphWithAnchor(
                it,
                font,
                textSizeData
            )
            dataContactCells.add(
                tableUtil.getCell(
                    paragraph,
                    colSpan = 1,
                    fixLeading = CvTableUtil.FIXED_LEADING_SMALL
                )
            )
        }

        val tableLanguage = tableUtil.getTable(columns = 1)
        val tableContact = tableUtil.getTable(columns = 1)

        tableLanguage.addCell(titleLanguageCell)
        tableLanguage.addCell(cellEmpty)

        dataLanguageCells.forEach {
            tableLanguage.addCell(it)
        }

        tableContact.addCell(titleContactCell)
        tableContact.addCell(cellEmpty)

        dataContactCells.forEach {
            tableContact.addCell(it)
        }

        val table = tableUtil.getTable(columns = COLUMNS)
        table.addCell(cellSpace)
        table.addCell(cellSpace)

        table.addCell(tableUtil.getCell(tableLanguage))
        table.addCell(tableUtil.getCell(tableContact))

        return table
    }
}