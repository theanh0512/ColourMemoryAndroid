package pham.user.colourmemoryandroid.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import pham.user.colourmemoryandroid.db.ColourMemoryDb
import pham.user.colourmemoryandroid.db.HighScoreDao
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun providesNCardDatabase(context: Context): ColourMemoryDb {
        return Room.databaseBuilder(
                context.applicationContext, ColourMemoryDb::class.java, "colour_memory.db")
                .build()
    }

    @Singleton
    @Provides
    fun provideHighScoreDao(db: ColourMemoryDb): HighScoreDao {
        return db.highScoreDao()
    }
}
