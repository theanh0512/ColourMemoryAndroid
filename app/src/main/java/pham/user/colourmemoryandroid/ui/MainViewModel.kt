package pham.user.colourmemoryandroid.ui

import android.arch.lifecycle.ViewModel
import pham.user.colourmemoryandroid.repository.HighScoreRepository
import javax.inject.Inject

/**
 * Created by Pham on 11/2/2018
 */
class MainViewModel @Inject constructor(val giftRepository: HighScoreRepository) : ViewModel() {

}
