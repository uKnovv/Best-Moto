package com.uknow.bestmoto.presentation.fragment.home

import com.uknow.bestmoto.model.Item

data class HomeFragmentState(
    val isLoading: Boolean? = false,
    val error: String? = null,
    val data_bikes: List<Item>? = null,
    val data_equipment: List<Item>? = null
)