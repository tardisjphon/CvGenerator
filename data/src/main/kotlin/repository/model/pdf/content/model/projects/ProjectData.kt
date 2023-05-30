package repository.model.pdf.content.model.projects


data class ProjectData(
    val id: Int,
    val company: String,
    val positionDate: String,
    val positionData: List<ProjectPosition>
)
