package repository.model.pdf.content.model.projects

import repository.model.pdf.content.model.stack.IProjectStack


data class ProjectPosition(
    val id: Int,
    val position: String,
    val positionType: PositionType,
    val description: String? = null,
    val scopeOfWork: String? = null,
    val scopeOfWorkTitle: String? = null,
    val scopeOfWorkList: List<String>? = null,
    val projectStack: List<IProjectStack>? = null
)