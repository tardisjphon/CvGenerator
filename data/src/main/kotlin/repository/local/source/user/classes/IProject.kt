package repository.local.source.user.classes

import repository.model.pdf.content.model.projects.ProjectData


interface IProject
{
    fun getTitle(): String
    fun getData(id: Int): List<ProjectData>
}