package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.IFocusAndRoles


class DataSourceFocusAndRolesKirkPL : IFocusAndRoles
{
    override fun getTitleFocus(): String
    {
        return ""
    }

    override fun getTitleRoles(): String
    {
        return "Role"
    }

    override fun getDataFocus(): String
    {
        return ""
    }

    override fun getDataRoles(): String
    {
        return "•      Młodszy oficer\n" + "•      Dowódca statku kosmicznego\n" + "•      Szef Operacji Gwiezdnej Floty"
    }
}