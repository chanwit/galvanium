package galvanium

class Module {
    
    String name
    String url = ""
    Boolean enabled = true

    static constraints = {
        name()
        url()
        enabled()
    }
}
