package pham.user.colourmemoryandroid.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pham.user.colourmemoryandroid.ColourMemoryViewModelFactory
import pham.user.colourmemoryandroid.ui.MainViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ColourMemoryViewModelFactory): ViewModelProvider.Factory
}
