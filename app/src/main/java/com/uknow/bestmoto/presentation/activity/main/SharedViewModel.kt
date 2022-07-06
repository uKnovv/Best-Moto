package com.uknow.bestmoto.presentation.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uknow.bestmoto.model.Bike
import com.uknow.bestmoto.model.Equipment

class SharedViewModel: ViewModel() {

    private val selectedBike = MutableLiveData<Bike>()
    private val selectedEquipment = MutableLiveData<Equipment>()

    fun getSelectedBike(): LiveData<Bike> = selectedBike

    fun getSelectedEquipment(): LiveData<Equipment> = selectedEquipment

    fun setSelectedBike(bike: Bike) {
        selectedBike.value = bike
    }

    fun setSelectedEquipment(equipment: Equipment) {
        selectedEquipment.value = equipment
    }


}