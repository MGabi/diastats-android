package space.healthdevs.diastats

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import org.koin.android.ext.android.startKoin
import space.healthdevs.diastats.koin.AppModules

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
        startKoin(this, AppModules.modules)
    }
}