package repository.model.pdf.content.model

import repository.model.pdf.content.model.projects.ProjectData


data class Projects(
    val id: Int,
    val title: String,
    val projects: List<ProjectData>? = null
)
