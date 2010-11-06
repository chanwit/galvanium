package galvanium

import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.*

//
// Shell composer
//
class IndexComposer extends GrailsComposer {

    def btnTest
    def mainInc

    def places = {
        "/$activity/$id?" {
            container = mainInc 
        }
    }

    def onClick_btnTest(e) {
        //
        // indexPresenter.btnTestClicked()
        //
    }

    def onBookmarkChange_wndMain(BookmarkEvent ev) {
        //
        // container.src = "${ev.bookmark}.zul"
        //
        mainInc.src = "core/${ev.bookmark}.zul"
    }

    def afterCompose = { window ->
    }
}
