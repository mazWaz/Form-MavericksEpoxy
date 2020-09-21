package live.mazwaz.latihan.state

import com.airbnb.mvrx.MvRxState

data class FormState(
    val search: String ? = null,
    val name: String ? = null,
    val nik: String? = null,
    val gender: String ? = null,
    val genderId: String ? = null,
    val position: String? = null,
    val factory: String? = null,
    val email: String? = null,
    val password: String? = null
): MvRxState