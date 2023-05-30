package repository.local.source.user.kirk.classes.all

import repository.model.pdf.general.CvLanguage
import repository.model.pdf.properties.IPdfProperties


class DataSourcePdfPropertiesKirk : IPdfProperties
{
    override var subject = "CV"
    override var author = "Kirk James"

    override var pathImages = "data/src/main/resources/image/"
    override var imageNamePhoto = "kirk_james.jpg"
    override var imageNameWatermark = "cv_generator_watermark.png"

    override fun getLanguages() = arrayListOf(
        CvLanguage.ENGLISH,
        CvLanguage.POLISH
    )
}