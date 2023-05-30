package repository.local.source.user

import repository.local.source.user.classes.*
import repository.local.source.user.kirk.classes.all.DataSourcePdfPropertiesKirk
import repository.local.source.user.kirk.classes.en.*
import repository.local.source.user.kirk.classes.pl.*
import repository.model.pdf.content.model.*
import repository.model.pdf.general.CvLanguage
import repository.model.pdf.general.User
import repository.model.source.DataModel
import repository.model.source.UserDataId


class DataModelCreatorKirk : IDataModelCreator
{
    override fun getDataModel(language: CvLanguage): DataModel
    {
        val user = User.KIRK
        val dsDocument = DataSourcePdfPropertiesKirk()
        val documentPdfData = dsDocument.getData(user)

        val id: Int
        val header: IHeader
        val summary: ISummary
        val focusAndRoles: IFocusAndRoles
        val projects: IProject
        val skills: ISkills
        val languageAndContact: ILanguageAndContact
        val education: IEducation
        val hobbies: IHobbies

        when (language)
        {
            CvLanguage.POLISH ->
            {
                id = 0
                header = DataSourceHeaderKirkPL(documentPdfData)
                summary = DataSourceSummaryKirkPL()
                focusAndRoles = DataSourceFocusAndRolesKirkPL()
                projects = DataSourceProjectKirkPL()
                skills = DataSourceSkillsKirkPL()
                languageAndContact = DataSourceLanguageAndContactKirkPL()
                education = DataSourceEducationKirkPL()
                hobbies = DataSourceHobbiesKirkPL()
            }

            CvLanguage.ENGLISH ->
            {
                id = 1
                header = DataSourceHeaderKirkEN(documentPdfData)
                summary = DataSourceSummaryKirkEN()
                focusAndRoles = DataSourceFocusAndRolesKirkEN()
                projects = DataSourceProjectKirkEN()
                skills = DataSourceSkillsKirkEN()
                languageAndContact = DataSourceLanguageAndContactKirkEN()
                education = DataSourceEducationKirkEN()
                hobbies = DataSourceHobbiesKirkEN()
            }
        }

        return DataModel(
            id = id,
            userDataId = UserDataId(
                id,
                user.ordinal,
                language
            ),
            header = Header(
                id,
                header.getFileName(),
                header.getName(),
                header.getPosition()
            ),
            summary = Summary(
                id,
                summary.getTitle(),
                summary.getSummaryData(),
                summary.getExperienceSince()
            ),
            focusAndRoles = FocusAndRoles(
                id,
                focusAndRoles.getTitleFocus(),
                focusAndRoles.getTitleRoles(),
                focusAndRoles.getDataFocus(),
                focusAndRoles.getDataRoles()
            ),
            projects = Projects(
                id,
                projects.getTitle(),
                projects.getData(id)
            ),
            skills = Skills(
                id,
                skillsTitle = skills.getTitle(),
                skills = skills.getSkills()
            ),
            languageAndContact = LanguageAndContact(
                id,
                languageAndContact.getLanguageTitle(),
                languages = languageAndContact.getLanguageData(),
                titleContact = languageAndContact.getContactTitle(),
                contacts = languageAndContact.getContactData()
            ),
            education = Education(
                id,
                title = education.getTitle(),
                school = education.getSchool()
            ),
            hobbies = Hobbies(
                id,
                title = hobbies.getTitle(),
                hobbies.getHobbies()
            )
        )
    }
}