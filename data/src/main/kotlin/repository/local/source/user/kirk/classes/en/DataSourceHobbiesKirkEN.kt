package repository.local.source.user.kirk.classes.en

import repository.local.source.user.classes.IHobbies


class DataSourceHobbiesKirkEN : IHobbies
{
    override fun getTitle(): String
    {
        return "Hobbies"
    }

    override fun getHobbies(): String
    {
        return "Horses"
    }
}