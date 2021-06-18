package com.priyanshumaurya8868.acompworldtask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.priyanshumaurya8868.acompworldtask.R
import com.priyanshumaurya8868.acompworldtask.databinding.WelcomeFagmentBinding
import com.priyanshumaurya8868.acompworldtask.ui.MainActivity
import com.priyanshumaurya8868.acompworldtask.ui.viewModel.MainViewModel

class WelcomeFragment : Fragment() {

    private var binding: WelcomeFagmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WelcomeFagmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).viewModel.getAcList().observe({lifecycle}){
            if (it.isNotEmpty()){
                findNavController().popBackStack()
            }
        }

        binding?.addAcBtn?.setOnClickListener {
            findNavController().navigate(R.id.detailFragment)
        }
    }

}