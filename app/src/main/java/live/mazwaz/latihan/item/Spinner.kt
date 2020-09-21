package live.mazwaz.latihan.item

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.core.widget.doOnTextChanged
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.OnViewRecycled
import kotlinx.android.synthetic.main.item_spinner.view.*
import kotlinx.android.synthetic.main.item_text_input.view.*
import live.mazwaz.latihan.R
import live.mazwaz.latihan.model.GenderList
import java.lang.reflect.Array

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Spinner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    init {
        View.inflate(context, R.layout.item_spinner, this)
    }


    @ModelProp(ModelProp.Option.IgnoreRequireHashCode)
    fun setAdapterpinner(data: kotlin.Array<Any>) {
        spinner.adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_dropdown_item,
            data
        )

    }

    @CallbackProp
    fun onSelectItem(onChange: ((Any) -> Unit)?) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parent?.selectedItem?.let { onChange?.invoke(it) }
            }
        }
    }

    @OnViewRecycled
    fun onRecycle() {
        spinner.onItemClickListener = null
    }
}
