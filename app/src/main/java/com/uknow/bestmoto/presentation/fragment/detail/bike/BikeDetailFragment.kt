package com.uknow.bestmoto.presentation.fragment.detail.bike

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentBikeDetailBinding

class BikeDetailFragment : Fragment(R.layout.fragment_bike_detail) {

    private lateinit var binding: FragmentBikeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBikeDetailBinding.bind(view)
    }

    companion object {

    }
}