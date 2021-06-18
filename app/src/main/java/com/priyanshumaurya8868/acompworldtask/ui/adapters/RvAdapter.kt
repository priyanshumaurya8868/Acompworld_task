package com.priyanshumaurya8868.acompworldtask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.priyanshumaurya8868.acompworldtask.R
import com.priyanshumaurya8868.acompworldtask.databinding.ItemRvBinding
import com.priyanshumaurya8868.acompworldtask.room.entities.AirConditioner

class RvAdapter : ListAdapter<AirConditioner, RvAdapter.MyVh>(
    object : DiffUtil.ItemCallback<AirConditioner>() {
        override fun areItemsTheSame(oldItem: AirConditioner, newItem: AirConditioner) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: AirConditioner, newItem: AirConditioner) =
            oldItem.toString() == newItem.toString()
    }
) {

    inner class MyVh(val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVh {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ItemRvBinding.inflate(inflater, parent, false)
        return MyVh(binding)
    }

    override fun onBindViewHolder(holder: MyVh, position: Int) {
        val ac = getItem(position)
        holder.binding.apply {
            if (ac.actype == "Window")
                ivAcTypePreview.setImageResource(R.drawable.window_ac_img)
            else
                ivAcTypePreview.setImageResource(R.drawable.split_ac_image)
            tvModelNo.text = ac.acModel
            tvPurchasedFrom.text = ac.purchasedFrom
            tvInstalledIn.text = ac.installedPlaced
        }
    }
}