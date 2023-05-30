package repository

import repository.model.pdf.general.CvLanguage
import repository.model.source.DataModel


interface IRepository
{
    fun getDataModel(language: CvLanguage): DataModel
}