package pham.user.colourmemoryandroid.vo

import android.arch.persistence.room.Entity

/**
 * Created by Pham on 11/2/17.
 */
@Entity(primaryKeys = arrayOf("id"), tableName = "high_score")
data class HighScore(val id: Int,
                     val name: String,
                     val score: Int)