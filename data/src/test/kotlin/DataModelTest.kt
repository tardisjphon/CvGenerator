import org.junit.jupiter.api.Test
import repository.local.json.JsonRepository
import repository.model.pdf.general.CvLanguage
import repository.model.pdf.general.User
import java.io.File


class DataModelTest
{
    private var jsonRepository: JsonRepository ?= null

    @Test
    fun createUser()
    {
        createKirk()
    }

    private fun createKirk()
    {
        createUser(
            User.KIRK,
            CvLanguage.ENGLISH
        )
        createUser(
            User.KIRK,
            CvLanguage.POLISH
        )
    }

    private fun createUser(
        user: User,
        language: CvLanguage
    )
    {
        val json = createBySimpleFactory(user, language)

        assert(!json.isNullOrBlank())

        json?.let {
            File("../" +jsonRepository?.getFullPath(language)).writeText(json)

            val dataModel = jsonRepository?.getDataModel(json)
            assert(dataModel != null)
        }
    }

    private fun createBySimpleFactory(
        user: User,
        language: CvLanguage
    ) : String?
    {
        println("\nUser: $user | Language: $language\n")

        val jsonRepository = JsonRepository(user)
        this.jsonRepository = jsonRepository
        val json = jsonRepository.createJson(language)
        println(json)
        return json
    }
}