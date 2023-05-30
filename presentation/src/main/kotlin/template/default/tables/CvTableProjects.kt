package template.default.tables

import com.lowagie.text.pdf.PdfPTable
import repository.model.pdf.content.model.stack.ItStack
import repository.model.pdf.content.model.stack.STStack
import repository.model.pdf.general.CvLanguage
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.COMPANY_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableProjects(
    private val cvUtil: CvUtil,
    private val cvLanguage: CvLanguage
)
{
    companion object
    {
        const val COLUMNS = 2
    }

    fun getTableTitle(
        title: String,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
    ): PdfPTable
    {
        val baseFontTitle = cvUtil.getFont()
            .getTimes()
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
            colSpan = 1,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )

        val table = tableUtil.getTable(columns = COLUMNS)

        table.addCell(cellSpace)
        table.addCell(cellSpace)

        table.addCell(cellTitle)
        table.addCell(cellSpace)

        return table
    }

    fun getTablePositionHeader(
        company: String,
        dateAndPositions: String,
        textSizeCompany: Float = COMPANY_TEXT_SIZE,
        textSizePosition: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val fontCompany = cvUtil.getFont()
            .getJulius()
        val baseFontPosition = cvUtil.getFont()
            .getHelvetica()
        val tableUtil = cvUtil.getTable()
        val cellCompany = tableUtil.getCell(
            tableUtil.getParagraph(
                company,
                fontCompany,
                fontCompany,
                textSizeCompany
            ),
            colSpan = 2,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )

        val cellPosition = tableUtil.getCell(
            tableUtil.getParagraph(
                dateAndPositions,
                baseFontPosition,
                textSizePosition
            ),
            colSpan = 2
        )

        val table = tableUtil.getTable(columns = COLUMNS)

        table.addCell(cellCompany)
        table.addCell(cellPosition)

        return table
    }

    fun getTablePositionData(
        data: repository.model.pdf.content.model.projects.ProjectPosition,
        textSize: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val tableUtil = cvUtil.getTable()
        val font = cvUtil.getFont()
            .getSource()
        val fontBold = cvUtil.getFont()
            .getSourceBold()

        val cellSpace = tableUtil.getCell(
            tableUtil.getParagraph(
                " ",
                font,
                fontBold,
                textSize
            ),
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )
        val cellSpaceSmall = tableUtil.getCell(
            tableUtil.getParagraph(
                " ",
                font,
                fontBold,
                textSize
            ),
            fixLeading = CvTableUtil.FIXED_LEADING_SMALL
        )
        val cellEmpty = tableUtil.getCell(
            tableUtil.getParagraph(
                "",
                font,
                fontBold,
                textSize
            )
        )
        val cellPosition = tableUtil.getCell(
            tableUtil.getParagraph(
                data.position,
                font,
                fontBold,
                textSize
            )
        )
        val cellDescription = tableUtil.getCell(
            tableUtil.getParagraph(
                data.description,
                font,
                fontBold,
                textSize
            )
        )

        val table = tableUtil.getTable(
            columns = COLUMNS,
            widths = floatArrayOf(
                30f,
                70f
            )
        )

        table.addCell(cellSpace)
        table.addCell(cellSpace)

        table.addCell(cellEmpty)
        table.addCell(cellPosition)

        table.addCell(cellEmpty)
        table.addCell(cellDescription)

        table.addCell(cellEmpty)
        table.addCell(cellEmpty)

        data.scopeOfWork?.let {
            table.addCell(cellEmpty)
            val cellScopeOfWork = tableUtil.getCell(
                tableUtil.getParagraph(
                    it,
                    font,
                    fontBold,
                    textSize
                )
            )
            table.addCell(cellScopeOfWork)
        }

        data.scopeOfWorkList?.let {
            if (it.isNotEmpty())
            {
                table.addCell(cellEmpty)
                val cellScopeOfWork = tableUtil.getCell(
                    tableUtil.getParagraph(
                        cvUtil.getText()
                            .listToBulletedTextList(
                                data.scopeOfWorkTitle,
                                it
                            ),
                        font,
                        fontBold,
                        textSize
                    )
                )
                table.addCell(cellScopeOfWork)
            }
        }

        data.projectStack?.let {
            val tableProjectStack = tableUtil.getTable(columns = 1)

            val sb = StringBuilder()
            it.forEach { techStack ->
                sb.append(techStack.title)
                sb.append(", ")
            }

            val projectStack = when (it[0])
            {
                is ItStack -> if (cvLanguage == CvLanguage.POLISH) "Stos technologiczny:" else "Tech stack:"
                is STStack -> if (cvLanguage == CvLanguage.POLISH) "Stos:" else "Stack:"
                else -> ""
            }

            val result = "$projectStack\n" + sb.toString()
                .dropLast(2)
            val paragraph = tableUtil.getParagraph(
                result,
                font,
                font,
                textSize
            )
            tableProjectStack.addCell(
                tableUtil.getCell(
                    paragraph,
                    colSpan = 1,
                    fixLeading = 12.5f,
                    isVisible = true
                )
            )

            table.addCell(cellSpaceSmall)
            table.addCell(cellSpaceSmall)

            table.addCell(cellEmpty)
            table.addCell(tableUtil.getCell(tableProjectStack))
        }

        return table
    }
}