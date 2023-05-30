package repository.local.source.user.spock.classes.all

import repository.model.pdf.general.CvLanguage
import repository.model.pdf.properties.IPdfProperties


class DataSourcePdfPropertiesSpock : IPdfProperties
{
    override var subject = "CV"
    override var author = "Spock"

    override var pathImages = "data/src/main/resources/image/"
    override var imageNamePhoto = "spock.jpg"
    override var imageNameWatermark = "cv_generator_watermark.png"

    override fun getLanguages() = arrayListOf(
        CvLanguage.ENGLISH,
        CvLanguage.POLISH
    )
}