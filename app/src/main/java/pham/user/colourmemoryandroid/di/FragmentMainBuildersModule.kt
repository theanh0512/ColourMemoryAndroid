package pham.user.colourmemoryandroid.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pham.user.colourmemoryandroid.ui.MainFragment

@Module
abstract class FragmentMainBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

}