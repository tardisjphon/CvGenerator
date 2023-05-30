package cv

import repository.IRepository
import repository.model.pdf.general.User
import repository.model.pdf.properties.IPdfProperties
import javax.inject.Inject


class CvFactory @Inject constructor(
    private val repository: IRepository,
    private val pdfProperties: IPdfProperties
) : IPdfProperties by pdfProperties
{
    fun create(user: User)
    {
        pdfProperties.getLanguages()
            .forEach { language ->
                Cv(
                    repository,
                    language,
                    pdfProperties.getData(user)
                )
            }
    }
}