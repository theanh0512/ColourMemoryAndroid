package pham.user.colourmemoryandroid.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import pham.user.colourmemoryandroid.R
import pham.user.colourmemoryandroid.di.Injectable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        fragmentManager = this.supportFragmentManager

        if (savedInstanceState == null && intent != null) {
            val myGiftFragment = MainFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.container, myGiftFragment)
                    .commitAllowingStateLoss()
        }
    }


    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}
