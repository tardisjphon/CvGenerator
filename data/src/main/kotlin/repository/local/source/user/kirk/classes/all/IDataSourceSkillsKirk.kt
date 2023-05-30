package repository.local.source.user.kirk.classes.all

import repository.local.source.user.classes.ISkills
import repository.model.pdf.content.model.skills.Skill
import repository.model.pdf.content.model.skills.SkillGroup
import repository.model.pdf.content.model.skills.SkillGroupStarTrekType
import repository.model.pdf.content.model.stack.STStack


interface IDataSourceSkillsKirk : ISkills
{
    override fun getSkills(): List<Skill>
    {
        return arrayListOf(
            Skill(
                id = 0,
                SkillGroup(SkillGroupStarTrekType.COMMAND),
                STStack.STRATEGIC_THINKING,
                experience = 5
            )
        )
    }
}