package galvanium

class Module {
    
    String name
    String url = ""
    Boolean enabled = true

    static mapping = {
        enabled index: true
    }

    static constraints = {
        name()
        url()
        enabled()
    }
}
