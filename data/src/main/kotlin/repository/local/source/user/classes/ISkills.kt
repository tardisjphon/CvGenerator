package repository.local.source.user.classes

import repository.model.pdf.content.model.skills.Skill


interface ISkills
{
    fun getTitle(): String
    fun getSkills(): List<Skill>
}