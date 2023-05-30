package repository.model.source

import repository.model.pdf.general.CvLanguage


data class UserDataId(
    val id: Int,
    val userId: Int,
    val language: CvLanguage
)
