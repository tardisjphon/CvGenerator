package repository.local.source.user.kirk.classes.en

import repository.local.source.user.classes.IFocusAndRoles


class DataSourceFocusAndRolesKirkEN : IFocusAndRoles
{
    override fun getTitleFocus(): String
    {
        return ""
    }

    override fun getTitleRoles(): String
    {
        return "Work roles"
    }

    override fun getDataFocus(): String
    {
        return ""
    }

    override fun getDataRoles(): String
    {
        return "•      Junior Officer\n" + "•      Starship Command\n" + "•      Chief of Starfleet Operations"
    }
}