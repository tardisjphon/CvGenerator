package repository.local.json.conventer

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import repository.local.json.adapters.ProjectStackInterfaceAdapter
import repository.local.json.adapters.SkilGroupInterfaceAdapter
import repository.model.pdf.content.model.skills.ISkillGroupType
import repository.model.pdf.content.model.stack.IProjectStack
import repository.model.source.DataModel


class JsonConventerDataModel
{
    fun dataModelToJson(dataModel: DataModel): String?
    {
        return try
        {
            Gson().toJson(dataModel)
        }
        catch (ex: JsonSyntaxException)
        {
            val message = ex.message ?: ""
            println("exception message: $message")
            null
        }
    }

    fun jsonToDataModel(json: String): DataModel?
    {
        return try
        {
            val gsonBuilder = GsonBuilder()
            gsonBuilder.registerTypeAdapter(
                IProjectStack::class.java,
                ProjectStackInterfaceAdapter()
            )
            gsonBuilder.registerTypeAdapter(
                ISkillGroupType::class.java,
                SkilGroupInterfaceAdapter()
            )
            val gson = gsonBuilder.create()
            gson.fromJson(
                json,
                object : TypeToken<DataModel?>()
                {}.type
            ) as? DataModel
        }
        catch (ex: Exception)
        {
            val message = ex.message ?: ""
            println("exception message: $message")
            null
        }
    }
}