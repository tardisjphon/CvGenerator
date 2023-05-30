package template.default.tables

import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.Image
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.pdf.PdfPTable
import utils.CvUtil
import utils.cv.CvTableUtil.Companion.COMPANY_TEXT_SIZE
import utils.cv.CvTableUtil.Companion.NAME_TEXT_SIZE


class CvTableHeader(private val cvUtil: CvUtil)
{
    companion object
    {
        const val COLUMNS = 2
        const val IMAGE_SIZE = 68f
    }

    fun getTable(
        fileName: String,
        name: String,
        position: String,
        baseFontName: BaseFont = cvUtil.getFont()
            .getTimes(),
        fontPosition: Font = cvUtil.getFont()
            .getJulius(),
        textSizeName: Float = NAME_TEXT_SIZE,
        textSizePosition: Float = COMPANY_TEXT_SIZE
    ): PdfPTable
    {
        val tableUtil = cvUtil.getTable()
        val nameCell = tableUtil.getCell(
            tableUtil.getParagraph(
                name,
                baseFontName,
                textSizeName
            ),
            colSpan = 1
        )
        val positionCell = tableUtil.getCell(
            tableUtil.getParagraph(
                position,
                fontPosition,
                fontPosition,
                textSizePosition
            ),
            colSpan = 1
        )

        val table = tableUtil.getTable(
            columns = COLUMNS,
            floatArrayOf(
                20f,
                80f
            )
        )

        try
        {
            val image = Image.getInstance(fileName)
            image.scaleToFit(
                IMAGE_SIZE,
                IMAGE_SIZE
            )
            val cell = tableUtil.getCell(image)
            table.addCell(cell)
        }
        catch (ex: Exception)
        {
            println("${ex.message}")
        }

        val tableNested = tableUtil.getTable(columns = 1)
        tableNested.addCell(nameCell)
        tableNested.addCell(positionCell)

        val nestedCell = tableUtil.getCell(tableNested)
        nestedCell.verticalAlignment = Element.ALIGN_MIDDLE
        table.addCell(nestedCell)

        return table
    }
}