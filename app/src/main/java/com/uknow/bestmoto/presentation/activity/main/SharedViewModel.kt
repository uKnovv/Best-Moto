package com.uknow.bestmoto.presentation.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uknow.bestmoto.model.Item

class SharedViewModel: ViewModel() {

    private val selectedItem = MutableLiveData<Item>()

    fun getSelectedItem(): LiveData<Item> = selectedItem

    fun setSelectedBike(item: Item) {
        selectedItem.value = item
    }

}