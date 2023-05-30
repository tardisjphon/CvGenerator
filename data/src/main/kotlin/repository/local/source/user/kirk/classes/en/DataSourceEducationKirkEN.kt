package repository.local.source.user.kirk.classes.en

import repository.local.source.user.classes.IEducation
import repository.model.pdf.content.model.Education


class DataSourceEducationKirkEN : IEducation
{
    private val education = Education(
        id = 0,
        "Education, courses and certifications",
        "2254       Starfleet Academy"
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