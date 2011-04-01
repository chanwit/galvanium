package galvanium

class Setting {

    String  key
    String  value
    Boolean enabled = true

    static mapping = {
        key index: true
    }

    static constraints = {
        key()
        value()
    }
}
