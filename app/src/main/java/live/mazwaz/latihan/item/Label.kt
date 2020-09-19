package live.mazwaz.latihan.item

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_text_label.view.*
import live.mazwaz.latihan.R
import java.security.AccessControlContext
import java.util.jar.Attributes

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Label @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr){
    init {
        View.inflate(context, R.layout.item_text_label,this)
        orientation = VERTICAL
    }
    @TextProp
    fun setText(text: CharSequence){
        this.label.text = text
    }
}