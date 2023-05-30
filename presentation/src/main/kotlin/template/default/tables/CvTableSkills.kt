package template.default.tables

import com.lowagie.text.pdf.PdfPTable
import repository.model.pdf.general.CvLanguage
import utils.CvUtil
import utils.cv.CvTableUtil
import utils.cv.CvTableUtil.Companion.COMMON_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.FIXED_LEADING_SMALL
import utils.cv.CvTableUtil.Companion.TITLE_TEXT_SIZE


class CvTableSkills(
    private val cvUtil: CvUtil,
    private val cvLanguage: CvLanguage
)
{
    companion object
    {
        const val COLUMNS = 2
    }

    fun getTable(
        title: String,
        data: List<repository.model.pdf.content.model.skills.Skill>,
        textSizeTitle: Float = TITLE_TEXT_SIZE,
        textSizeCommon: Float = COMMON_TEXT_SIZE
    ): PdfPTable
    {
        val fontBase = cvUtil.getFont()
            .getTimes()
        val font = cvUtil.getFont()
            .getSource()
        val fontBold = cvUtil.getFont()
            .getSourceBold()
        val tableUtil = cvUtil.getTable()

        val cellEmpty = tableUtil.getCell(
            "",
            fontBase,
            textSizeTitle
        )
        val cellSpace = tableUtil.getCell(
            " ",
            fontBase,
            textSizeTitle,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )
        val cellTitle = tableUtil.getCell(
            title,
            fontBase,
            textSizeTitle,
            colSpan = 1,
            fixLeading = CvTableUtil.FIXED_LEADING_BIG
        )

        val table = tableUtil.getTable(columns = COLUMNS)

        table.addCell(cellSpace)
        table.addCell(cellSpace)

        table.addCell(cellTitle)
        table.addCell(cellSpace)

        table.addCell(cellSpace)
        table.addCell(cellSpace)

        var lastGroup: repository.model.pdf.content.model.skills.SkillGroup? = null
        data.forEach {
            if (it.group != lastGroup)
            {
                lastGroup = it.group
                table.addCell(
                    tableUtil.getCell(
                        tableUtil.getParagraph(
                            it.group.description,
                            font,
                            fontBold,
                            textSizeCommon
                        ),
                        colSpan = 1,
                        fixLeading = FIXED_LEADING_SMALL
                    )
                )
                table.addCell(cellEmpty)
            }
            table.addCell(
                tableUtil.getCell(
                    tableUtil.getParagraph(
                        it.techStack.title,
                        font,
                        fontBold,
                        textSizeCommon
                    ),
                    colSpan = 1,
                    fixLeading = FIXED_LEADING_SMALL
                )
            )
            it.experience?.let {
                table.addCell(
                    tableUtil.getCell(
                        tableUtil.getParagraph(
                            cvUtil.getText()
                                .getYearsText(
                                    it,
                                    cvLanguage
                                ),
                            font,
                            fontBold,
                            textSizeCommon
                        ),
                        colSpan = 1,
                        fixLeading = FIXED_LEADING_SMALL
                    )
                )
            }
        }

        return table
    }
}