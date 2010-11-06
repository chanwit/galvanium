package org.zkoss

import org.zkoss.zk.ui.event.Events
import org.zkoss.zk.ui.event.EventListener

class EventBus implements EventListener {

    def page
    
    def bind = {
        // page.addEventListener("onBookmarkChange", this)
    }

    public void onEvent(Event event) throws UiException {
        //
        // #!/token
        // desktop.bookmark = "!" + token
        //
        desktop.bookmark = "!" + event.data["token"]
    }

    def methodMissing(String name, Object args) {
        if(name.startsWith("fire")) {
            def data = [token:"aaa", args: args]
            Events.postEvent("on" + name[4..-1], null, data)
        } else {
            //
            // throw new MethodMissing
            //
        }
    }

}