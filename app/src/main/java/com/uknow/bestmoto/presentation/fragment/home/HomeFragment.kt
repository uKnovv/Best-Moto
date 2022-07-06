package com.uknow.bestmoto.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentHomeBinding
import com.uknow.bestmoto.model.Bike
import com.uknow.bestmoto.model.Equipment
import com.uknow.bestmoto.presentation.activity.main.SharedViewModel
import com.uknow.bestmoto.presentation.adapter.BikesAdapter
import com.uknow.bestmoto.presentation.adapter.EquipmentAdapter

class HomeFragment : Fragment(R.layout.fragment_home),
    BikesAdapter.BikeItemCallback,
    EquipmentAdapter.EquipmentItemCallBack
{

    private lateinit var binding: FragmentHomeBinding

    private val bikesDataSet = mutableListOf<Bike>()
    private val equipmentDataSet = mutableListOf<Equipment>()

    private val sharedViewModel by activityViewModels<SharedViewModel>()
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]

        // Delete it later pls
        bikesDataSet.add(Bike("Nigga"))
        bikesDataSet.add(Bike("Nigga"))
        equipmentDataSet.add(Equipment("Eldak"))
        equipmentDataSet.add(Equipment("Analnya Zatiychka"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        updateTitle()
        setupRecyclers()
    }

    private fun updateTitle() = binding.run {
        topAppBar.title = "Hello, Alex"
    }

    private fun setupRecyclers() {
        binding.run {
            rvBikes.apply {
                adapter = BikesAdapter(dataSet = bikesDataSet, callback = this@HomeFragment)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
            rvEquipment.apply {
                adapter = EquipmentAdapter(dataSet = equipmentDataSet, callback = this@HomeFragment)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { newState ->
                updateUI(newState)
            }
        }
    }

    private fun updateUI(state: HomeFragmentState) {

    }

    private fun clearAndUpdateBikesRecycler(newDataSet: List<Bike>) {
        val adapter = binding.rvBikes.adapter

        // Clear old data
        val previousSize = adapter?.itemCount ?: 0
        bikesDataSet.clear()
        adapter?.notifyItemRangeRemoved(0, previousSize)

        // Set new data
        bikesDataSet.addAll(newDataSet)
        adapter?.notifyItemRangeInserted(0, newDataSet.size)
    }

    private fun clearAndUpdateEquipmentRecycler(newDataSet: List<Equipment>) {
        val adapter = binding.rvEquipment.adapter

        // Clear old data
        val previousSize = adapter?.itemCount ?: 0
        equipmentDataSet.clear()
        adapter?.notifyItemRangeRemoved(0, previousSize)

        // Set new data
        equipmentDataSet.addAll(newDataSet)
        adapter?.notifyItemRangeInserted(0, newDataSet.size)
    }

    override fun onClick(bike: Bike, position: Int) {
        sharedViewModel.setSelectedBike(bike)
        navigateToBikeDetails()
    }

    override fun onClick(equipment: Equipment, position: Int) {
        sharedViewModel.setSelectedEquipment(equipment)
        navigateToEquipmentDetails()
    }

    private fun navigateToBikeDetails() {
        val directions = HomeFragmentDirections.actionHomeFragmentToBikeDetailFragment()
        val extras = FragmentNavigatorExtras()
        findNavController().navigate(directions, extras)
    }

    private fun navigateToEquipmentDetails() {
        val directions = HomeFragmentDirections.actionHomeFragmentToEquipmentDetailFragment()
        val extras = FragmentNavigatorExtras()
        findNavController().navigate(directions, extras)
    }
}