package repository.model.pdf.content.model


data class LanguageAndContact(
    val id: Int,
    val titleLanguage: String,
    val languages: List<Language>,
    val titleContact: String,
    val contacts: List<String>
)
