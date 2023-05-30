package repository.di

import dagger.Module
import dagger.Provides
import repository.model.pdf.general.User


@Module
class DataModule(private val user: User)
{
    @Provides
    fun provideUser() : User
    {
        return user
    }
}