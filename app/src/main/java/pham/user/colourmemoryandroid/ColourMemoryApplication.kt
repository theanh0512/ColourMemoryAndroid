package pham.user.colourmemoryandroid

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pham.user.colourmemoryandroid.di.AppInjector
import javax.inject.Inject

/**
 * Created by Pham on 11/2/2018.
 */

class ColourMemoryApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    val TAG = "ColourMemoryApplication"

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}
