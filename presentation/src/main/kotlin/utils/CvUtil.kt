package utils

import com.lowagie.text.Document
import utils.cv.*


class CvUtil(private val document: Document)
{
    private val cvDocumentUtil by lazy {
        CvDocumentUtil(
            document,
            this
        )
    }
    private val cvFontUtil by lazy { CvFontUtil() }
    private val cvTableUtil by lazy { CvTableUtil(cvTagsUtil) }
    private val cvTagsUtil by lazy { CvTagsUtil() }
    private val cvTextUtil by lazy { CvTextUtil() }

    fun getDocument() = cvDocumentUtil
    fun getFont() = cvFontUtil
    fun getTable() = cvTableUtil
    fun getTags() = cvTagsUtil
    fun getText() = cvTextUtil
}