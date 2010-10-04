package galvanium

import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.*

class IndexComposer extends GrailsComposer {

    def mainInc

    def onBookmarkChange_wndMain(BookmarkEvent ev) {
        mainInc.src = "core/${ev.bookmark}.zul"
    }

    def afterCompose = { window ->
    }
}
