package di

import repository.di.DataModule
import repository.model.pdf.general.User


class AppDagger(private val user: User)
{
    private val applicationGraph by lazy {
        DaggerApplicationGraph.builder()
            .dataModule(DataModule(user))
            .cvFactoryModule(CvFactoryModule(user))
            .build()
    }

    init
    {
        startDagger()
    }

    private fun startDagger()
    {
        applicationGraph.cvFactory()
            .create(user)
    }
}