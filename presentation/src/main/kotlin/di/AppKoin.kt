package di

import cv.CvFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.inject
import repository.IRepository
import repository.local.json.JsonRepository
import repository.local.source.user.kirk.classes.all.DataSourcePdfPropertiesKirk
import repository.local.source.user.spock.classes.all.DataSourcePdfPropertiesSpock
import repository.model.pdf.general.User
import repository.model.pdf.properties.IPdfProperties

/**
 * docs ->
 * https://insert-koin.io/docs/reference/koin-core/definitions/
 * https://github.com/InsertKoinIO/koin
 */
class AppKoin(private val user: User)
{
    private val cvFactory: CvFactory by inject(CvFactory::class.java)

    init
    {
        startKoin()
        cvFactory.create(user)
    }

    private fun startKoin()
    {
        val dataModule = module {
            single { JsonRepository(user) } bind IRepository::class
        }

        val cvFactoryModule = module {
            singleOf(::CvFactory)
        }

        val pdfPropertiesModule = module {
            when (user)
            {
                User.SPOCK -> singleOf(::DataSourcePdfPropertiesSpock) bind IPdfProperties::class
                User.KIRK -> singleOf(::DataSourcePdfPropertiesKirk) bind IPdfProperties::class
            }
        }

        org.koin.core.context.startKoin {
            modules(
                dataModule + cvFactoryModule + pdfPropertiesModule
            )
        }
    }
}