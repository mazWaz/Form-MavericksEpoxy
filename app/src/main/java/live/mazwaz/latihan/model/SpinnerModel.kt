package live.mazwaz.latihan.model

class GenderList(idgen: String, desc: String) {
    var idgen: String? = idgen
    var desc: String? = desc

    override fun toString(): String {
        return desc!! // Want to display in the Spinner list.
    }
}