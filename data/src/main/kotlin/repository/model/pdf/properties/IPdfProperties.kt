package repository.model.pdf.properties

import repository.model.pdf.general.CvLanguage
import repository.model.pdf.general.User


interface IPdfProperties
{
    var subject: String
    var author: String
    var pathImages: String
    var imageNamePhoto: String
    var imageNameWatermark: String

    fun getCreator() = "$subject Generator by $author"
    fun getTitle() = "$subject $author"
    fun getLanguages(): ArrayList<CvLanguage>

    private fun getPathPhoto() = pathImages + imageNamePhoto
    private fun getPathWatermark() = pathImages + imageNameWatermark

    fun getData(user: User): PdfPropertiesData
    {
        return PdfPropertiesData(
            user,
            getTitle(),
            subject,
            author,
            getCreator(),
            getLanguages(),
            getPathPhoto(),
            getPathWatermark()
        )
    }
}