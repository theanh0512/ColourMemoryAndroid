package pham.user.colourmemoryandroid.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import pham.user.colourmemoryandroid.vo.HighScore

/**
 * Interface for database access for HighScore related operations.
 */
@Dao
interface HighScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(highScore: HighScore)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHighScores(highScores: List<HighScore>)

    @Query("SELECT * FROM high_score")
    fun findAllHighScores(): LiveData<List<HighScore>>

    @Query("DELETE FROM high_score WHERE id = :id")
    fun deleteHighScoreById(id: Int)

    @Query("DELETE FROM high_score")
    fun deleteAllHighScores()

    @Update
    fun updateHighScore(HighScore: HighScore)
}