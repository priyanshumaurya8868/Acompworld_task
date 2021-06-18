package com.priyanshumaurya8868.acompworldtask.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.priyanshumaurya8868.acompworldtask.room.AcRepo

class AcViewModelFactory(
    private val acRepo: AcRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(acRepo) as T
    }

}