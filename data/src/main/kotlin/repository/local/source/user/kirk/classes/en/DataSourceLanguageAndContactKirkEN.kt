package repository.local.source.user.kirk.classes.en

import repository.local.source.user.classes.ILanguageAndContact
import repository.model.pdf.content.model.Language


class DataSourceLanguageAndContactKirkEN : ILanguageAndContact
{
    override fun getLanguageTitle(): String
    {
        return "Languages"
    }

    override fun getLanguageData(): List<Language>
    {
        return arrayListOf(
            Language(
                "•   English",
                ""
            )
        )
    }

    override fun getContactTitle(): String
    {
        return "Contact and Networks"
    }

    override fun getContactData(): List<String>
    {
        return arrayListOf(
            "•   http://trekipedia.com/file/James_T._Kirk"
        )
    }
}