package repository.local.source.user.kirk.classes.en

import repository.local.source.user.classes.ISummary


class DataSourceSummaryKirkEN : ISummary
{
    override fun getTitle(): String
    {
        return "Summary"
    }

    override fun getSummaryData(): String
    {
        return "• USS Enterprise and a five-year mission\n" + "• commander of the USS Enterprise-A\n" + "• experience in teamwork and freelancer work in a team"
    }

    override fun getExperienceSince(): String
    {
        return "<b>Experience since:</b> 2268"
    }
}