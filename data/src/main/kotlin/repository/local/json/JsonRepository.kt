package repository.local.json

import repository.IRepository
import repository.local.json.conventer.JsonConventerDataModel
import repository.local.source.user.DataModelCreatorKirk
import repository.local.source.user.DataModelCreatorSpock
import repository.model.pdf.general.CvLanguage
import repository.model.pdf.general.User
import repository.model.source.DataModel
import repository.model.source.UserDataId
import java.io.File
import javax.inject.Inject


class JsonRepository @Inject constructor(
    private val user: User
) : IRepository
{
    private var pathPrefix = "data/src/main/resources/json/"
    private val converterDataModel by lazy { JsonConventerDataModel() }

    fun createJson(language: CvLanguage = CvLanguage.ENGLISH) : String?
    {
        val dmc = when (user)
        {
            User.SPOCK -> DataModelCreatorSpock()
            User.KIRK -> DataModelCreatorKirk()
        }

        val dataModel = dmc.getDataModel(language)
        return getJson(dataModel)
    }

    fun getDataModel(json: String) : DataModel? = converterDataModel.jsonToDataModel(json)

    fun getJson(dataModel: DataModel) : String? = converterDataModel.dataModelToJson(dataModel)

    override fun getDataModel(language: CvLanguage): DataModel
    {
        val fullPath = getFullPath(language)
        if (fullPath.isEmpty()) return getEmptyUserDataModel()
        val file = File(fullPath)
        if (!file.isFile) return getEmptyUserDataModel()
        val lines = file.readLines()
        if (lines.isEmpty()) return getEmptyUserDataModel()
        val result = lines.joinToString("\n")
        return converterDataModel.jsonToDataModel(result) ?: getEmptyUserDataModel()
    }

    fun getFullPath(language: CvLanguage): String
    {
        return pathPrefix + user.name.lowercase() + "_" + language.shortName.lowercase() + ".json"
    }

    private fun getEmptyUserDataModel(): DataModel
    {
        return DataModel(
            0,
            UserDataId(
                0,
                User.SPOCK.ordinal,
                CvLanguage.POLISH
            )
        )
    }
}