package com.uknow.bestmoto.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.GoodsItemBinding
import com.uknow.bestmoto.model.Item

class ItemAdapter(
    private val dataSet: List<Item>,
    private val callback: ItemCallback
): RecyclerView.Adapter<ItemAdapter.BikeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BikeViewHolder = BikeViewHolder(
       LayoutInflater.from(parent.context).inflate(R.layout.goods_item, parent, false)
    )

    override fun onBindViewHolder(holder: BikeViewHolder, position: Int) {
        holder.bind(dataSet[position], position, callback)
    }

    override fun getItemCount(): Int = dataSet.size

    inner class BikeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = GoodsItemBinding.bind(itemView)

        fun bind(item: Item, position: Int, callback: ItemCallback) {
            binding.run {
                root.setOnClickListener {
                    callback.onClick(item = item, position = position)
                }
            }
        }
    }

    interface ItemCallback {
        fun onClick(item: Item, position: Int)
    }
}