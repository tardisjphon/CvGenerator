package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.IHobbies


class DataSourceHobbiesKirkPL : IHobbies
{
    override fun getTitle(): String
    {
        return "Zainteresowania"
    }

    override fun getHobbies(): String
    {
        return "Konie"
    }
}