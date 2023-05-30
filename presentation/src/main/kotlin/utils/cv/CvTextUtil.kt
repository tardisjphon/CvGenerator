package utils.cv

import repository.model.pdf.general.CvLanguage


class CvTextUtil
{
    fun listToBulletedTextList(
        title: String?,
        list: List<String>?
    ): String
    {
        list?.let {
            val sb = StringBuilder()
            if (title?.isNotBlank() == true)
            {
                sb.append("$title:\n")
            }
            list.forEach {
                val prefix = "    • "
                val suffix = "\n"
                sb.append(prefix + it + suffix)
            }
            return sb.toString()
                .dropLast(1)
        }
        return ""
    }

    fun getYearsText(
        number: Int,
        cvLanguage: CvLanguage
    ): String
    {
        return "$number " + when (cvLanguage)
        {
            CvLanguage.POLISH ->
            {
                when (number)
                {
                    1 -> "rok"
                    2, 3, 4 -> "lata"
                    5, 6, 7, 8, 9, 10 -> "lat"
                    else -> "lat"
                }
            }

            CvLanguage.ENGLISH ->
            {
                when (number)
                {
                    1 -> "year"
                    else -> "years"
                }
            }

            else -> ""
        }
    }
}