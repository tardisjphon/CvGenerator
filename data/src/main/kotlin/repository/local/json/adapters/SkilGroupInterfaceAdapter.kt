package repository.local.json.adapters

import com.google.gson.*
import repository.model.pdf.content.model.skills.SkillGroupItType
import repository.model.pdf.content.model.skills.SkillGroupStarTrekType
import repository.model.pdf.content.model.skills.ISkillGroupType
import java.lang.reflect.Type


class SkilGroupInterfaceAdapter : JsonDeserializer<ISkillGroupType>, JsonSerializer<ISkillGroupType>
{
    override fun serialize(
        src: ISkillGroupType,
        typeOfSrc: Type?,
        context: JsonSerializationContext
    ): JsonElement?
    {
        return context.serialize(src)
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext
    ): ISkillGroupType?
    {
        return try
        {
            val it = context.deserialize(
                json,
                SkillGroupItType::class.java
            ) as? SkillGroupItType

            it ?: context.deserialize(
                json,
                SkillGroupStarTrekType::class.java
            ) as? SkillGroupStarTrekType
        }
        catch (ex: Exception)
        {
            println("${ex.message}")
            return null
        }
    }
}