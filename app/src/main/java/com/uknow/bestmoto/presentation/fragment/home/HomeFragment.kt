package com.uknow.bestmoto.presentation.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentHomeBinding
import com.uknow.bestmoto.model.Item
import com.uknow.bestmoto.presentation.activity.main.SharedViewModel
import com.uknow.bestmoto.presentation.adapter.ItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),
    ItemAdapter.ItemCallback
{

    private lateinit var binding: FragmentHomeBinding

    private val bikesDataSet = mutableListOf<Item>()
    private val equipmentDataSet = mutableListOf<Item>()

    private val sharedViewModel by activityViewModels<SharedViewModel>()
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]
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
                adapter = ItemAdapter(dataSet = bikesDataSet, callback = this@HomeFragment)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
            rvEquipment.apply {
                adapter = ItemAdapter(dataSet = equipmentDataSet, callback = this@HomeFragment)
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
        if (state.isLoading == true) {

        }

        if (state.data_bikes != null) {

        }

        if (state.data_equipment != null) {

        }

        if (state.error != null) {

        }
    }

    private fun clearAndUpdateBikesRecycler(newDataSet: List<Item>) {
        val adapter = binding.rvBikes.adapter

        // Clear old data
        val previousSize = adapter?.itemCount ?: 0
        bikesDataSet.clear()
        adapter?.notifyItemRangeRemoved(0, previousSize)

        // Set new data
        bikesDataSet.addAll(newDataSet)
        adapter?.notifyItemRangeInserted(0, newDataSet.size)
    }

    private fun clearAndUpdateEquipmentRecycler(newDataSet: List<Item>) {
        val adapter = binding.rvEquipment.adapter

        // Clear old data
        val previousSize = adapter?.itemCount ?: 0
        equipmentDataSet.clear()
        adapter?.notifyItemRangeRemoved(0, previousSize)

        // Set new data
        equipmentDataSet.addAll(newDataSet)
        adapter?.notifyItemRangeInserted(0, newDataSet.size)
    }

    override fun onClick(bike: Item, position: Int) {
        sharedViewModel.setSelectedBike(bike)
        navigateToDetails()
    }

    private fun navigateToDetails() {
        val directions = HomeFragmentDirections.actionHomeFragmentToBikeDetailFragment()
        val extras = FragmentNavigatorExtras()
        findNavController().navigate(directions, extras)
    }
}