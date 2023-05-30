package repository.model.pdf.content.model.skills

import repository.model.pdf.content.model.stack.IProjectStack


data class Skill(
    val id: Int,
    var group: SkillGroup,
    var techStack: IProjectStack,
    var level: Int? = null,
    var experience: Int? = null,
    var lastUsed: Int? = null
)
