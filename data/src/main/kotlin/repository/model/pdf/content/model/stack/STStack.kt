package repository.model.pdf.content.model.stack


enum class STStack(override val title: String) : IProjectStack
{
    COMBAT("Combat"),
    DIPLOMACY("Diplomacy"),
    STRATEGIC_THINKING("Strategic thinking"),
    SUPPRESSION_EMOTIONS("Suppression of emotions")
}