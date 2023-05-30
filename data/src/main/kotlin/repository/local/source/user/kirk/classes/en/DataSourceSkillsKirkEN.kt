package repository.local.source.user.kirk.classes.en

import repository.local.source.user.kirk.classes.all.IDataSourceSkillsKirk
import repository.model.pdf.content.model.skills.Skill
import repository.model.pdf.content.model.skills.SkillGroup
import repository.model.pdf.content.model.skills.SkillGroupStarTrekType


class DataSourceSkillsKirkEN : IDataSourceSkillsKirk
{
    override fun getTitle(): String
    {
        return "Skills"
    }

    override fun getSkills(): List<Skill>
    {
        val skills = super.getSkills()
        skills.map {
            (it.group as? SkillGroup)?.let { group ->
                group.description = when (group.type)
                {
                    SkillGroupStarTrekType.COMMAND -> "<b>Command</b>"
                    SkillGroupStarTrekType.ENGINEERING -> "<b>Engineering</b>"
                    SkillGroupStarTrekType.OPERATIONS -> "<b>Operations</b>"
                    SkillGroupStarTrekType.SCIENCE -> "<b>Science</b>"
                    SkillGroupStarTrekType.SECTION31 -> "<b>Section 31</b>"
                    SkillGroupStarTrekType.TRAINING -> "<b>Training</b>"
                    else -> ""
                }
            }
        }
        return skills
    }
}