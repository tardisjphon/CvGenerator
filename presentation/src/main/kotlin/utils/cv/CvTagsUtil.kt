package utils.cv


class CvTagsUtil
{
    companion object
    {
        const val TAG_START_BOLD = "<b>"
        const val TAG_END_BOLD = "</b>"
    }

    fun getPairWithBold(text: String?): Pair<String, String>
    {
        val boldedTextWithTags = getBoldedText(text)
        val noBoldedText = text?.replace(
            boldedTextWithTags,
            ""
        )
        val boldedText = getTextWithoutBoldTags(boldedTextWithTags)
        return Pair(
            noBoldedText ?: "",
            boldedText
        )
    }

    fun removeNotLinkChars(text: String): String
    {
        return text.replace(
            "[•\\s]+".toRegex(),
            ""
        )
    }

    private fun getBoldedText(text: String?): String
    {
        return getTextBetweenTags(
            text,
            TAG_START_BOLD,
            TAG_END_BOLD
        )
    }

    private fun getTextWithoutBoldTags(text: String): String
    {
        return removeTags(
            text,
            TAG_START_BOLD,
            TAG_END_BOLD
        )
    }

    private fun removeTags(
        text: String,
        startTag: String,
        endTag: String
    ): String
    {
        return text.replace(
            startTag,
            ""
        )
            .replace(
                endTag,
                ""
            )
    }

    private fun getTextBetweenTags(
        text: String?,
        startTag: String,
        endTag: String
    ): String
    {
        text?.let {
            val wantedChars = "ĄĆĘŁŃÓŚŹŻąćęłńóśźż•"
            val regex = "$startTag([${wantedChars}A-Za-z0-9/\\s:]*)$endTag"
            val result = regex.toRegex()
                .find(text)
            val values = result?.groupValues
            return if (values?.isNotEmpty() == true) values[0] else ""
        }
        return ""
    }
}