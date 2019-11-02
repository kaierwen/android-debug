package github.kaierwen.android.debugdemo

import android.app.Application
import github.kaierwen.android.library_beagle_kotlin.BeagleEntrance

/**
 * @author kaiyuan.zhang
 * @since 2019/11/2
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) BeagleEntrance.init(this)
    }
}