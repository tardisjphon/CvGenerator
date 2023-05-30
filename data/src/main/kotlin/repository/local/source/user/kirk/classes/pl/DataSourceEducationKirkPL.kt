package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.IEducation
import repository.model.pdf.content.model.Education


class DataSourceEducationKirkPL : IEducation
{
    private val education = Education(
        id = 0,
        "Edukacja",
        "2254       Akademia Gwiezdnej Floty"
    )

    override fun getTitle(): String
    {
        return education.title
    }

    override fun getSchool(): String
    {
        return education.school
    }
}