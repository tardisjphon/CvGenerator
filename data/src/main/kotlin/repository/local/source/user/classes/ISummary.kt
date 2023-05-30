package repository.local.source.user.classes


interface ISummary
{
    fun getTitle(): String
    fun getSummaryData(): String
    fun getExperienceSince(): String
}