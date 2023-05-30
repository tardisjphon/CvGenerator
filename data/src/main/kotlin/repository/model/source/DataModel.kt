package repository.model.source

import repository.model.pdf.content.model.*


data class DataModel(
    val id: Int,
    val userDataId: UserDataId,
    val header: Header? = null,
    val summary: Summary? = null,
    val focusAndRoles: FocusAndRoles? = null,
    val projects: Projects? = null,
    val skills: Skills? = null,
    val languageAndContact: LanguageAndContact? = null,
    val education: Education? = null,
    val hobbies: Hobbies? = null
)