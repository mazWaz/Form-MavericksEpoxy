package live.mazwaz.latihan.viewmodel


import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import live.mazwaz.latihan.base.MvRxViewModel
import live.mazwaz.latihan.state.FormState

class FormViewModel(
    state: FormState
): MvRxViewModel<FormState>(state){

    companion object: MvRxViewModelFactory<FormViewModel, FormState>{
        override fun create(viewModelContext: ViewModelContext, state: FormState): FormViewModel? {
            return FormViewModel(state)
        }
    }

    fun clearState() = setState { FormState() }
    fun setSearch(value: String) = setState { copy(search = value) }
    fun setName(value: String) = setState { copy(name = value) }
    fun setNik(value: String) = setState { copy(nik = value) }
    fun setGender(value: String) = setState { copy(gender = value) }
    fun setGenderId(value: String) = setState { copy(genderId = value) }
    fun setPosition(value: String) = setState { copy(position = value) }
    fun setFactory(value: String) = setState { copy(factory = value) }
    fun setEmail(value: String) = setState { copy(email = value) }
    fun setPassword(value: String) = setState { copy(password = value) }
}
