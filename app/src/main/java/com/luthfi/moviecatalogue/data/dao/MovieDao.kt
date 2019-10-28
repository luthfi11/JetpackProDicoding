package com.luthfi.moviecatalogue.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.luthfi.moviecatalogue.data.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * from t_movie ORDER BY release_date DESC")
    fun getAllMovie(): DataSource.Factory<Int, Movie>

    @Query("SELECT * from t_movie WHERE id = :id")
    fun checkMovie(id: Int?): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)
}