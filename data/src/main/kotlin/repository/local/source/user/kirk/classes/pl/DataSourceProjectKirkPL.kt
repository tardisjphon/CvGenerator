package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.IProject
import repository.model.pdf.content.model.projects.ProjectData


class DataSourceProjectKirkPL : IProject
{
    override fun getTitle(): String
    {
        return "Kariera"
    }

    override fun getData(id: Int): List<ProjectData>
    {
        return arrayListOf()
    }
}