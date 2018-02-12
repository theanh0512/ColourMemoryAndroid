package pham.user.colourmemoryandroid.repository

import android.content.Context
import pham.user.colourmemoryandroid.AppExecutors
import pham.user.colourmemoryandroid.db.ColourMemoryDb
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Pham on 11/2/2018.
 */
@Singleton
class HighScoreRepository @Inject constructor(val context: Context,
                                              val colourMemoryDb: ColourMemoryDb, val appExecutors: AppExecutors) {


    companion object {
        private val TAG = "TheMovie"
    }
}