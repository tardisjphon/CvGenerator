package repository.local.source.user.classes

import repository.model.pdf.content.model.Language


interface ILanguageAndContact
{
    fun getLanguageTitle(): String
    fun getLanguageData(): List<Language>
    fun getContactTitle(): String
    fun getContactData(): List<String>
}