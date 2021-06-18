package com.priyanshumaurya8868.acompworldtask.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshumaurya8868.acompworldtask.room.AcRepo
import com.priyanshumaurya8868.acompworldtask.room.entities.AirConditioner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel( private val repo: AcRepo) : ViewModel(){

    fun insert(ac: AirConditioner) = viewModelScope.launch(Dispatchers.IO) {
        repo.insertAc(ac)
    }

    fun getAcList() = repo.getAcList()


}