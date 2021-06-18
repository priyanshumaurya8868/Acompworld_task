package com.priyanshumaurya8868.acompworldtask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.priyanshumaurya8868.acompworldtask.R
import com.priyanshumaurya8868.acompworldtask.databinding.DetailFragmentBinding
import com.priyanshumaurya8868.acompworldtask.room.entities.AirConditioner
import com.priyanshumaurya8868.acompworldtask.ui.MainActivity

class DetailFragment : Fragment() {

    private lateinit var datePicker: MaterialDatePicker<Long>
    private val DATE_PICKER_TAG = "date_picker_tag"
    private var binding: DetailFragmentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDatePicker()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            addAcBtn.setOnClickListener {
                saveDetails()
            }
            etPurchasedDate.setOnClickListener {
                showDatePicker(it)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun saveDetails() {
        if (validateInputs()) {
            binding?.apply {
                val ac = AirConditioner(
                    actype = spinerAcType.selectedItem.toString(),
                    acModel = etAcModel.text.toString(),
                    installedPlaced = etInstalledPlace.text.toString(),
                    purchasedDate = etPurchasedDate.text.toString(),
                    purchasedFrom = etPurchasedFrom.text.toString(),
                    serialNo = etSerialNo.text.toString()
                )
                (activity as MainActivity).viewModel.insert(ac)
            }
            findNavController().popBackStack()

        }
    }

    private fun showDatePicker(it: View?) {
        binding?.etPurchasedDate?.isEnabled = false
        activity?.supportFragmentManager?.let { activity ->
            datePicker.show(
                activity,
                DATE_PICKER_TAG
            )
        }
    }


    private fun setUpDatePicker() {
        datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Purchased date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        datePicker.addOnPositiveButtonClickListener {
            binding?.etPurchasedDate?.setText(datePicker.headerText)
        }

        datePicker.addOnDismissListener {
            binding?.etPurchasedDate?.isEnabled = true
        }

    }


    private fun validateInputs(): Boolean {
        if (binding?.spinerAcType?.selectedItem.toString() == "--Select AC Type--") {
            binding?.root?.let {
                Snackbar.make(it, "Select AC Type...!", Snackbar.LENGTH_SHORT).show()
            }
            return false
        }

        if (binding?.etAcModel?.text.toString().trim().isBlank()) {
            binding?.etAcModel?.error = "Field Required!"
            binding?.etAcModel?.requestFocus()
            return false
        }
        if (binding?.etInstalledPlace?.text.toString().trim().isBlank()) {
            binding?.etInstalledPlace?.error = "Field Required!"
            binding?.etInstalledPlace?.requestFocus()
            return false
        }
        if (binding?.etPurchasedDate?.text.toString().trim().isBlank()) {
            binding?.etInstalledPlace?.error = "Field Required!"
            binding?.etInstalledPlace?.requestFocus()
            return false
        }
        if (binding?.etPurchasedFrom?.text.toString().trim().isBlank()) {
            binding?.etPurchasedFrom?.error = "Field Required!"
            binding?.etPurchasedFrom?.requestFocus()
            return false
        }
        if (binding?.etSerialNo?.text.toString().trim().isBlank()) {
            binding?.etSerialNo?.error = "Field Required!"
            binding?.etSerialNo?.requestFocus()
            return false
        }
        return true
    }

}