package galvanium

import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.*

//
// Shell composer
//
class IndexComposer extends GrailsComposer {


    def mainInc

    def places = {
        "/$activity/$id?" {
           container = mainInc 
        }
    }


    def onBookmarkChange_wndMain(BookmarkEvent ev) {
        mainInc.src = "core/${ev.bookmark}.zul"
    }

    def afterCompose = { window ->
    }
}
