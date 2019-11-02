package github.kaierwen.android.debugdemo;

import android.app.Application;

import github.kaierwen.android.library_beagle_kotlin.BeagleEntrance;

/**
 * @author kaiyuan.zhang
 * @since 2019/11/2
 */
public class App2 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BeagleEntrance.init(this);
    }
}
