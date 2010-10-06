package galvanium.core

import org.zkoss.zkgrails.*
import galvanium.*

class ProjectsComposer extends GrailsComposer {

    def vboxProjects

    def afterCompose = { window ->
        def projects = Project.list(max: 10)
        vboxProjects.append {
            projects.each { p ->
                vbox {
                    a(href:"#projects/${p.shortName}", label:p.name)
                    label(value: p.description)
                }
            }
        }
    }

}