package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.kirk.classes.all.IDataSourceSkillsKirk
import repository.model.pdf.content.model.skills.Skill
import repository.model.pdf.content.model.skills.SkillGroup
import repository.model.pdf.content.model.skills.SkillGroupStarTrekType


class DataSourceSkillsKirkPL : IDataSourceSkillsKirk
{
    override fun getTitle(): String
    {
        return "Umiejętności"
    }

    override fun getSkills(): List<Skill>
    {
        val skills = super.getSkills()
        skills.map {
            (it.group as? SkillGroup)?.let { group ->
                group.description = when (group.type)
                {
                    SkillGroupStarTrekType.COMMAND -> "<b>Dowodzenie</b>"
                    SkillGroupStarTrekType.ENGINEERING -> "<b>Inżynieria</b>"
                    SkillGroupStarTrekType.OPERATIONS -> "<b>Operacyjny</b>"
                    SkillGroupStarTrekType.SCIENCE -> "<b>Nauka</b>"
                    SkillGroupStarTrekType.SECTION31 -> "<b>Sekcja 31</b>"
                    SkillGroupStarTrekType.TRAINING -> "<b>Trening</b>"
                    else -> ""
                }
            }
        }
        return skills
    }
}