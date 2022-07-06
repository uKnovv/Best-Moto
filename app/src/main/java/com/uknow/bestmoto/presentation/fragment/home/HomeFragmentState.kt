package com.uknow.bestmoto.presentation.fragment.home

import com.uknow.bestmoto.model.Bike
import com.uknow.bestmoto.model.Equipment

data class HomeFragmentState(
    val isLoading: Boolean? = false,
    val error: String? = null,
    val data_bikes: List<Bike>? = null,
    val data_equipment: List<Equipment>? = null
)