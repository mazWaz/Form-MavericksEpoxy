package live.mazwaz.latihan.item

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.text.Spanned
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.airbnb.epoxy.*
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.item_text_input.view.*
import live.mazwaz.latihan.R

enum class TextInputType {
    PW, EMAIL, TEXT, NUMBER
}

typealias TextChangeCallback = ((CharSequence?) -> Unit)

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TextInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var textChangeDisposable: Disposable? = null

    init {
        View.inflate(context, R.layout.item_text_input, this)
    }

    @ModelProp
    fun setTextInput(text: CharSequence?) {
        if (setTextOnlyIfDifferent(editText, text)) {
            // If the text changed then we move the cursor to the end of the new text.
            // This allows us to fill in text programmatically if needed,
            // like a search suggestion, but if the user is typing and the view is rebound
            // we won't lose their cursor position.
            editText.setSelection(editText.length())
        }
    }

    @CallbackProp
    fun textChangeCallback(onChange: ((String) -> Unit)?) {
        editText.doOnTextChanged { text, _, _, _ ->
            onChange?.invoke(text.toString())
        }
    }
    @TextProp
    fun setPlaceholder(placeholder: CharSequence) {
        editText.hint = placeholder
    }

    @ModelProp
    fun setImage(Img: Int) {
        val editTextInput:EditText = editText
        when(Img){
            0 -> null
            else -> editTextInput.setCompoundDrawablesWithIntrinsicBounds(Img, 0, 0, 0)
        }
    }

    @TextProp
    fun setOnError(placeholder: CharSequence) {
        editText.error = when(placeholder){
            "" -> null
            else -> placeholder
        }
    }

    @ModelProp
    fun setInputType(inputType: TextInputType) {
        editText.inputType = when (inputType) {
            TextInputType.PW -> InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            TextInputType.EMAIL -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            TextInputType.TEXT -> InputType.TYPE_CLASS_TEXT
            TextInputType.NUMBER -> InputType.TYPE_CLASS_NUMBER
        }
        editText.typeface = Typeface.SANS_SERIF
    }

    @OnViewRecycled
    fun onRecycle() {
        editText.removeTextChangedListener(null)
    }

    private fun setTextOnlyIfDifferent(textView: TextView, text: CharSequence?): Boolean {
        if (!isTextDifferent(text, textView.text)) {
            // Previous text is the same. No op.
            return false
        }

        textView.text = text ?: ""
        return true
    }

    private fun isTextDifferent(str1: CharSequence?, str2: CharSequence?): Boolean {
        if (str1 === str2) {
            return false
        }
        if (str1 == null || str2 == null) {
            return true
        }
        val length = str1.length
        if (length != str2.length) {
            return true
        }

        if (str1 is Spanned) {
            return str1 != str2
        }

        for (i in 0 until length) {
            if (str1[i] != str2[i]) {
                return true
            }
        }
        return false
    }
}
