package com.priyanshumaurya8868.acompworldtask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.priyanshumaurya8868.acompworldtask.R
import com.priyanshumaurya8868.acompworldtask.databinding.RecordFragmentBinding
import com.priyanshumaurya8868.acompworldtask.ui.MainActivity
import com.priyanshumaurya8868.acompworldtask.ui.adapters.RvAdapter

class RecordFragment : Fragment() {

    private var binding: RecordFragmentBinding? = null
    private lateinit var madapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        madapter = RvAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecordFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.addAcBtn?.setOnClickListener {
            findNavController().navigate(R.id.detailFragment)
        }
        setUpRv()
        (activity as MainActivity).viewModel.getAcList().observe({ lifecycle }) {
            if (it.isNullOrEmpty()){
                findNavController().navigate(R.id.welcomeFragment)
            }
            madapter.submitList(it)
        }
    }

    private fun setUpRv() {
        binding?.apply {
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.adapter = madapter
        }
    }

}