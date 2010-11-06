package galvanium

class IndexPresenter extends GrailsPresenter {

    def eventBus

    def btnAddContactClicked() {
        eventBus.fireAddContact()
    }
    
    def btnItemClicked(ContactDetails cd) {
        eventBus.fireEditContact(cd.id)
    }

}