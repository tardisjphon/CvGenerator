package repository.model.pdf.content.model

import repository.model.pdf.content.model.skills.Skill


data class Skills(
    val id: Int,
    val skillsTitle: String? = null,
    val skills: List<Skill>? = null
)
