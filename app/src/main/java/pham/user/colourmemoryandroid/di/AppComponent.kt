package pham.user.colourmemoryandroid.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import pham.user.colourmemoryandroid.ColourMemoryApplication
import javax.inject.Singleton

/**
 * Created by Pham on 11/2/2018.
 */
@Singleton
@Component(modules = arrayOf(
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule::class, AppModule::class, MainActivityModule::class))
interface AppComponent {
    fun inject(app: ColourMemoryApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}