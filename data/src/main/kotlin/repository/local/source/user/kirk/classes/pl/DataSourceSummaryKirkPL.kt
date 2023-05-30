package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.ISummary


class DataSourceSummaryKirkPL : ISummary
{
    override fun getTitle(): String
    {
        return "Podsumowanie"
    }

    override fun getSummaryData(): String
    {
        return "• USS Enterprise i pięcioletnia misja\n" + "• dowódca USS Enterprise-A\n" + "• doświadczenie w pracy zespołowej"
    }

    override fun getExperienceSince(): String
    {
        return "<b>Doświadczenie od:</b> 2268"
    }
}