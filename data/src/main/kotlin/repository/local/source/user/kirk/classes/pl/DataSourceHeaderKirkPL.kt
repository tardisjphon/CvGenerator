package repository.local.source.user.kirk.classes.pl

import repository.local.source.user.classes.IHeader
import repository.model.pdf.properties.PdfPropertiesData


class DataSourceHeaderKirkPL(private val pdfPropertiesData: PdfPropertiesData) : IHeader
{
    override fun getFileName(): String
    {
        return pdfPropertiesData.headerImagePath
    }

    override fun getName(): String
    {
        return pdfPropertiesData.author
    }

    override fun getPosition(): String
    {
        return "Admirał Gwiezdnej Floty"
    }
}