package com.uknow.bestmoto.presentation.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentBikeDetailBinding
import com.uknow.bestmoto.model.Item
import com.uknow.bestmoto.presentation.activity.main.SharedViewModel
import com.uknow.bestmoto.util.setupAutoExtendFab

class BikeDetailFragment : Fragment(R.layout.fragment_bike_detail) {

    private lateinit var binding: FragmentBikeDetailBinding

    private val sharedViewModel by activityViewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBikeDetailBinding.bind(view)
        binding.run {
            nsvContent.setupAutoExtendFab(fabAddToCart)
        }
    }

    override fun onStart() {
        super.onStart()
        sharedViewModel.getSelectedItem().observe(viewLifecycleOwner) { selectedItem ->
            updateUI(selectedItem)
        }
    }

    private fun updateUI(item: Item) {

    }
}