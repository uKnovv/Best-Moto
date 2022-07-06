package com.uknow.bestmoto.presentation.fragment.detail.equipment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentEquipmentDetailBinding
import com.uknow.bestmoto.model.Bike
import com.uknow.bestmoto.model.Equipment
import com.uknow.bestmoto.presentation.activity.main.SharedViewModel
import com.uknow.bestmoto.util.setupAutoExtendFab

class EquipmentDetailFragment : Fragment(R.layout.fragment_equipment_detail) {

    private lateinit var binding: FragmentEquipmentDetailBinding

    private val sharedViewModel by activityViewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEquipmentDetailBinding.bind(view)
        binding.run {
            nsvContent.setupAutoExtendFab(fabAddToCart)
        }
    }

    override fun onStart() {
        super.onStart()
        sharedViewModel.getSelectedEquipment().observe(viewLifecycleOwner) { selectedEquipment ->
            updateUI(selectedEquipment)
        }
    }

    private fun updateUI(equipment: Equipment) {

    }
}