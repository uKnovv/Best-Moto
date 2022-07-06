package com.uknow.bestmoto.presentation.fragment.detail.equipment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentEquipmentDetailBinding

class EquipmentDetailFragment : Fragment(R.layout.fragment_equipment_detail) {

    private lateinit var binding: FragmentEquipmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEquipmentDetailBinding.bind(view)
    }

    companion object {

    }
}