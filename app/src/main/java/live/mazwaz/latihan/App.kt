package live.mazwaz.latihan

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.multidex.MultiDexApplication
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory


class App: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(applicationContext)
    }
}