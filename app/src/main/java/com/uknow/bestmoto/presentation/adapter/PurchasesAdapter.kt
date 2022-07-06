package com.uknow.bestmoto.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.PurchaseItemBinding
import com.uknow.bestmoto.model.Purchase

class PurchasesAdapter(
    private val dataSet: List<Purchase>,
    private val callback: PurchaseItemCallback
) : RecyclerView.Adapter<PurchasesAdapter.PurchaseViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PurchaseViewHolder = PurchaseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.purchase_item, parent, false)
    )

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(dataSet[position], position, callback)
    }

    override fun getItemCount(): Int = dataSet.size

    inner class  PurchaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = PurchaseItemBinding.bind(itemView)

        fun bind(purchase: Purchase, position: Int, callback: PurchaseItemCallback) {
            binding.run {
                root.setOnClickListener {
                    callback.onClick(purchase = purchase, position = position)
                }
            }
        }
    }

    interface PurchaseItemCallback {
        fun onClick(purchase: Purchase, position: Int)
    }
}