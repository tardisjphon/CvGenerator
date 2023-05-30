package repository.model.pdf.properties

import repository.model.pdf.general.CvLanguage
import repository.model.pdf.general.User


data class PdfPropertiesData(
    val user: User,
    val title: String,
    val subject: String,
    val author: String,
    val creator: String,
    val languages: List<CvLanguage>,
    val headerImagePath: String,
    val footerImagePath: String
)
