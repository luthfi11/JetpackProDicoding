package com.luthfi.moviecatalogue.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.luthfi.moviecatalogue.data.dao.MovieDao
import com.luthfi.moviecatalogue.data.dao.TVShowDao
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.model.TVShow

@Database(entities = [Movie::class, TVShow::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TVShowDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "db_movie_catalogue"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}