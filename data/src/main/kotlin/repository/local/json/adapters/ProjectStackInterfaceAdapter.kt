package repository.local.json.adapters

import com.google.gson.*
import repository.model.pdf.content.model.stack.ItStack
import repository.model.pdf.content.model.stack.IProjectStack
import repository.model.pdf.content.model.stack.STStack
import java.lang.reflect.Type


class ProjectStackInterfaceAdapter : JsonDeserializer<IProjectStack>, JsonSerializer<IProjectStack>
{
    override fun serialize(
        src: IProjectStack,
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
    ): IProjectStack?
    {
        return try
        {
            val it = context.deserialize(
                json,
                ItStack::class.java
            ) as? ItStack

            it ?: context.deserialize(
                json,
                STStack::class.java
            ) as? STStack
        }
        catch (ex: Exception)
        {
            println("${ex.message}")
            return null
        }
    }
}