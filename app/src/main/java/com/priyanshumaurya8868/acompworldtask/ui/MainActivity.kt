package com.priyanshumaurya8868.acompworldtask.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.priyanshumaurya8868.acompworldtask.R
import com.priyanshumaurya8868.acompworldtask.room.AcDatabase
import com.priyanshumaurya8868.acompworldtask.room.AcRepo
import com.priyanshumaurya8868.acompworldtask.ui.viewModel.AcViewModelFactory
import com.priyanshumaurya8868.acompworldtask.ui.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {


    val viewModel: MainViewModel by viewModels { AcViewModelFactory( AcRepo(AcDatabase.invoke(context = this.applicationContext))) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController



    }
}