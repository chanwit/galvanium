package galvanium

import org.zkoss.zkgrails.*

class IndexComposer extends GrailsComposer {

    def tabs
    def tabPanels

    def afterCompose = { window ->
        def modules = Module.findAllByEnabled(true)
        modules.each { m ->
            tabs.append {
                tab(label: m.name)
            }
            tabPanels.append {
                tabpanel {
                    if(m.url != null && m.url != "") {
                        include(src: m.url)
                    }
                }
            }
        }
    }
}
