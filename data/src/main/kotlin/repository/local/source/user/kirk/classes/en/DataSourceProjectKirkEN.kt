package repository.local.source.user.kirk.classes.en

import repository.local.source.user.classes.IProject
import repository.model.pdf.content.model.projects.ProjectData


class DataSourceProjectKirkEN : IProject
{
    override fun getTitle(): String
    {
        return "Career and Projects"
    }

    override fun getData(id: Int): List<ProjectData>
    {
        return arrayListOf()
    }
}