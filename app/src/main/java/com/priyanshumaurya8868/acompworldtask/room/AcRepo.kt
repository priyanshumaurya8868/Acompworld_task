package com.priyanshumaurya8868.acompworldtask.room

import com.priyanshumaurya8868.acompworldtask.room.entities.AirConditioner

class AcRepo(
    val db: AcDatabase
) {
    fun getAcList() = db.getdao().getAcList()

    suspend fun insertAc(ac: AirConditioner) = db.getdao().insert(ac)

}