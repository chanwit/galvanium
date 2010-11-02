package galvanium

class Setting {

    String  key
    String  value
    Boolean enabled = true

    static constraints = {
        key()
        value()
    }
}
