package com.priyanshumaurya8868.acompworldtask.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.priyanshumaurya8868.acompworldtask.room.entities.AirConditioner


@Dao
interface AcDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ac: AirConditioner)

    @Query("SELECT * FROM AirConditioner")
    fun getAcList(): LiveData<List<AirConditioner>>
}