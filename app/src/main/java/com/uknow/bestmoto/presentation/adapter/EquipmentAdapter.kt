package com.uknow.bestmoto.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.EquipmentItemBinding
import com.uknow.bestmoto.model.Equipment

class EquipmentAdapter(
    private val dataSet: List<Equipment>,
    private val callback: EquipmentItemCallBack
): RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EquipmentViewHolder = EquipmentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.equipment_item, parent, false)
    )

    override fun onBindViewHolder(holder: EquipmentViewHolder, position: Int) {
        holder.bind(dataSet[position], position, callback)
    }

    override fun getItemCount(): Int = dataSet.size

    inner class EquipmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = EquipmentItemBinding.bind(itemView)

        fun bind(equipment: Equipment, position: Int, callback: EquipmentItemCallBack) {
            binding.run {
                root.setOnClickListener {
                    callback.onClick(equipment = equipment, position = position)
                }
            }
        }
    }

    interface EquipmentItemCallBack {
        fun onClick(equipment: Equipment, position: Int)
    }
}