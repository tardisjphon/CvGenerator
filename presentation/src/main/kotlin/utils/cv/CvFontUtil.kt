package utils.cv

import com.lowagie.text.Font
import com.lowagie.text.FontFactory
import com.lowagie.text.pdf.BaseFont


class CvFontUtil
{
    companion object
    {
        const val coding = BaseFont.CP1250
        const val folder = "presentation/src/main/resources/font/"
    }

    private val helveticaFont: BaseFont by lazy {
        BaseFont.createFont(
            BaseFont.HELVETICA,
            coding,
            BaseFont.NOT_EMBEDDED
        )
    }

    private val timesFont: BaseFont by lazy {
        BaseFont.createFont(
            BaseFont.TIMES_ROMAN,
            coding,
            BaseFont.NOT_EMBEDDED
        )
    }

    fun getHelvetica() = helveticaFont
    fun getTimes() = timesFont
    fun getSans() = sansFont
    fun getSource() = sourceFont
    fun getSourceBold() = sourceFontBold
    fun getJulius() = juliusFont

    private lateinit var sansFont: Font
    private lateinit var juliusFont: Font
    private lateinit var sourceFont: Font
    private lateinit var sourceFontBold: Font

    //https://fonts.google.com/

    init
    {
        setCustom()
    }

    private fun setCustom()
    {
        FontFactory.register(folder + "InstrumentSans-Regular.ttf")
        sansFont = FontFactory.getFont(
            "Instrument Sans",
            coding,
            BaseFont.EMBEDDED
        )

        FontFactory.register(folder + "JuliusSansOne-Regular.ttf")
        juliusFont = FontFactory.getFont(
            "Julius Sans One",
            coding,
            BaseFont.EMBEDDED
        )

        FontFactory.register(folder + "SourceSansPro-Regular.ttf")
        sourceFont = FontFactory.getFont(
            "Source Sans Pro",
            coding,
            BaseFont.EMBEDDED
        )
        sourceFontBold = FontFactory.getFont(
            "Source Sans Pro",
            coding,
            BaseFont.EMBEDDED
        )
        sourceFontBold.style = Font.BOLD
    }
}