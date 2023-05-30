package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.ILanguageAndContact
import repository.model.pdf.content.model.Language


class DataSourceLanguageAndContactKirkPL : ILanguageAndContact
{
    override fun getLanguageTitle(): String
    {
        return "Języki"
    }

    override fun getLanguageData(): List<Language>
    {
        return arrayListOf(
            Language(
                "•   Angielski",
                ""
            )
        )
    }

    override fun getContactTitle(): String
    {
        return "Kontakt"
    }

    override fun getContactData(): List<String>
    {
        return arrayListOf(
            "•   http://trekipedia.com/file/James_T._Kirk"
        )
    }
}