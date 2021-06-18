package com.priyanshumaurya8868.acompworldtask.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.priyanshumaurya8868.acompworldtask.room.dao.AcDao
import com.priyanshumaurya8868.acompworldtask.room.entities.AirConditioner


@Database(
    entities = [AirConditioner::class],
    version = 2
)
abstract class AcDatabase : RoomDatabase() {

    abstract fun getdao(): AcDao

    companion object {
        @Volatile
        var instance: AcDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AcDatabase::class.java,
            "ac_database.db"
        ).build()

    }


}