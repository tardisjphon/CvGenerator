package template.default

import com.lowagie.text.Document
import repository.model.pdf.general.CvLanguage
import repository.model.source.DataModel
import template.ITemplate
import template.default.tables.*
import utils.CvUtil


class DefaultTemplate(
    private val cvLanguage: CvLanguage,
    private val dataModel: DataModel,
    private val document: Document,
    private val cvUtil: CvUtil
) : ITemplate
{
    private val tableHeader by lazy { CvTableHeader(cvUtil) }
    private val tableSummary by lazy { CvTableSummary(cvUtil) }
    private val tableFocusAndRoles by lazy { CvTableFocusAndRoles(cvUtil) }
    private val tableProjects by lazy {
        CvTableProjects(
            cvUtil,
            cvLanguage
        )
    }
    private val tableSkills by lazy {
        CvTableSkills(
            cvUtil,
            cvLanguage
        )
    }
    private val tableEducation by lazy { CvTableEducation(cvUtil) }
    private val tableLanguageAndContact by lazy { CvTableLanguageAndContact(cvUtil) }
    private val tableHobbies by lazy { CvTableHobby(cvUtil) }

    override fun setPdfContent()
    {
        addHeader()
        addSummary()
        addFocusAndRoles()
        addProjects()
        addSkills()
        addEducation()
        addLanguageAndContact()
        addHobbies()
    }

    override fun addHeader()
    {
        dataModel.header?.let { data ->
            document.add(
                tableHeader.getTable(
                    data.fileName,
                    data.userName,
                    data.userPosition
                )
            )
        }
    }

    override fun addSummary()
    {
        dataModel.summary?.let { data ->
            document.add(
                tableSummary.getTable(
                    data.title,
                    data.summary,
                    data.experienceSince
                )
            )
        }
    }

    override fun addFocusAndRoles()
    {
        dataModel.focusAndRoles?.let { data ->
            document.add(
                tableFocusAndRoles.getTable(
                    data.titleFocus,
                    data.titleRoles,
                    data.focus,
                    data.roles,
                )
            )
        }
    }

    override fun addProjects()
    {
        dataModel.projects?.projects?.let { data ->

            if (data.isEmpty()) return@let

            dataModel.projects?.let { projects ->
                document.add(
                    tableProjects.getTableTitle(
                        projects.title
                    )
                )
            }

            data.forEach { projectData ->

                document.add(
                    tableProjects.getTablePositionHeader(
                        projectData.company,
                        projectData.positionDate
                    )
                )

                projectData.positionData.forEach { data ->
                    document.add(
                        tableProjects.getTablePositionData(
                            data
                        )
                    )
                }
            }
        }
    }

    override fun addSkills()
    {
        dataModel.skills?.let { data ->
            document.add(
                tableSkills.getTable(
                    data.skillsTitle ?: "",
                    data.skills ?: listOf()
                )
            )
        }
    }

    override fun addEducation()
    {
        dataModel.education?.let { data ->
            document.add(
                tableEducation.getTable(
                    data.title,
                    data.school
                )
            )
        }
    }

    override fun addLanguageAndContact()
    {
        dataModel.languageAndContact?.let { data ->
            document.add(
                tableLanguageAndContact.getTable(
                    data.titleLanguage,
                    data.languages,
                    data.titleContact,
                    data.contacts
                )
            )
        }
    }

    override fun addHobbies()
    {
        dataModel.hobbies?.let { data ->
            document.add(
                tableHobbies.getTable(
                    data.title,
                    data.hobbies
                )
            )
        }
    }
}