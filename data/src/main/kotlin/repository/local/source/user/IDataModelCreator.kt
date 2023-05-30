package repository.local.source.user

import repository.model.pdf.general.CvLanguage
import repository.model.source.DataModel


interface IDataModelCreator
{
    fun getDataModel(language: CvLanguage): DataModel
}