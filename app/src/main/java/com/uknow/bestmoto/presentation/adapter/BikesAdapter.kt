package com.uknow.bestmoto.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.BikeItemBinding
import com.uknow.bestmoto.model.Bike

class BikesAdapter(
    private val dataSet: List<Bike>,
    private val callback: BikeItemCallback
): RecyclerView.Adapter<BikesAdapter.BikeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BikeViewHolder = BikeViewHolder(
       LayoutInflater.from(parent.context).inflate(R.layout.bike_item, parent, false)
    )

    override fun onBindViewHolder(holder: BikeViewHolder, position: Int) {
        holder.bind(dataSet[position], position, callback)
    }

    override fun getItemCount(): Int = dataSet.size

    inner class BikeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = BikeItemBinding.bind(itemView)

        fun bind(bike: Bike, position: Int, callback: BikeItemCallback) {
            binding.run {
                root.setOnClickListener {
                    callback.onClick(bike = bike, position = position)
                }
            }
        }
    }

    interface BikeItemCallback {
        fun onClick(bike: Bike, position: Int)
    }
}