package live.mazwaz.latihan.base

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

abstract class MvRxViewModel<S : MvRxState>(state: S) : BaseMvRxViewModel<S>(state)