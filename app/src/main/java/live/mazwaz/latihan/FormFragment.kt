package live.mazwaz.latihan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import live.mazwaz.latihan.base.BaseEpoxyFragment
import live.mazwaz.latihan.base.MvRxEpoxyController
import live.mazwaz.latihan.base.buildController
import live.mazwaz.latihan.databinding.FragmentFormBinding
import live.mazwaz.latihan.item.*
import live.mazwaz.latihan.viewmodel.FormViewModel

class FormFragment : BaseEpoxyFragment<FragmentFormBinding>() {
    private val viewModel: FormViewModel by activityViewModel()
    override var fragmentLayout: Int = R.layout.fragment_form
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun epoxyController(): MvRxEpoxyController = buildController {
        Log.d("TAGOIOI", R.drawable.ic_launcher_background.toString())
        withState(viewModel) {
            label {
                id("Label Top")
                text("\n\n$it\n\n")
            }
            textInput {
                id("InputSearch")
                placeholder("Search")
                inputType(TextInputType.TEXT)
                textInput(it.password)
                onError("")
                image(R.drawable.ic_google)
                textChangeCallback { viewModel.setSearch(it) }
            }
            label {
                id("LabelName")
                text("Name")
            }
            textInput {
                id("InputName")
                placeholder("Nama")
                inputType(TextInputType.TEXT)
                textInput(it.name)
                onError("")
                image(0)
                textChangeCallback { viewModel.setName(it) }
            }
            label {
                id("LabelNik")
                text("Nik")
            }
            textInput {
                id("InputNik")
                placeholder("Nik")
                inputType(TextInputType.NUMBER)
                textInput(it.nik)
                onError("")
                image(0)
                textChangeCallback { viewModel.setNik(it) }
            }
            label {
                id("LabelPosition")
                text("Position")
            }
            textInput {
                id("InputPosition")
                placeholder("Position")
                inputType(TextInputType.TEXT)
                textInput(it.position)
                onError("")
                textChangeCallback { viewModel.setPosition(it) }
            }
            label {
                id("LabelFactory")
                text("Factory")
            }
            textInput {
                id("InputFactory")
                placeholder("Factory")
                inputType(TextInputType.TEXT)
                textInput(it.factory)
                onError("")
                image(0)
                textChangeCallback { viewModel.setFactory(it) }
            }
            label {
                id("LabelEmail")
                text("Email")
            }
            textInput {
                id("InputEmail")
                placeholder("Email")
                inputType(TextInputType.EMAIL)
                textInput(it.email)
                onError("")
                image(0)
                textChangeCallback { viewModel.setEmail(it) }
            }
            label {
                id("LabelPassword")
                text("Password")
            }
            textInput {
                id("InputPassword")
                placeholder("Password")
                inputType(TextInputType.PW)
                textInput(it.password)
                onError("")
                image(0)
                textChangeCallback { viewModel.setPassword(it) }
            }

        }

    }

}