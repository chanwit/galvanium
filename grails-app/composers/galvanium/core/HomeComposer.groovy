package galvanium.core

import galvanium.*
import org.zkoss.zkgrails.*

class HomeComposer extends GrailsComposer {

    def mainTabs
    def tabs
    def tabPanels
    def wndMain

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