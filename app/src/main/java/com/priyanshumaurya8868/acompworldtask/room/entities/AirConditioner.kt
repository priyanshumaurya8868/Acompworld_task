package com.priyanshumaurya8868.acompworldtask.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class AirConditioner(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var actype: String? = null,
    var acModel: String? = null,
    var serialNo: String? = null,
    var purchasedDate: String? = null,
    var installedPlaced: String? = null,
    var purchasedFrom: String? = null
) : Serializable
