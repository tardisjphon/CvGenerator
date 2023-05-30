package di

import dagger.Module
import dagger.Provides
import repository.IRepository
import repository.local.json.JsonRepository
import repository.local.source.user.kirk.classes.all.DataSourcePdfPropertiesKirk
import repository.local.source.user.spock.classes.all.DataSourcePdfPropertiesSpock
import repository.model.pdf.properties.IPdfProperties
import repository.model.pdf.general.User


@Module
class CvFactoryModule(private val user: User)
{
    @Provides
    fun provideJsonRepository(): IRepository
    {
        return JsonRepository(user)
    }

    @Provides
    fun providePdfProperties(): IPdfProperties
    {
        return when (user)
        {
            User.SPOCK -> DataSourcePdfPropertiesSpock()
            User.KIRK -> DataSourcePdfPropertiesKirk()
        }
    }
}