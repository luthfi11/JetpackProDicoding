package com.luthfi.moviecatalogue.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.luthfi.moviecatalogue.data.model.TVShow

@Dao
interface TVShowDao {

    @Query("SELECT * from t_tvshow ORDER BY first_air_date DESC")
    fun getAllTV(): DataSource.Factory<Int, TVShow>

    @Query("SELECT * from t_tvshow WHERE id = :id")
    fun checkTV(id: Int?): LiveData<List<TVShow>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTV(tvShow: TVShow)

    @Delete
    suspend fun deleteTV(tvShow: TVShow)
}