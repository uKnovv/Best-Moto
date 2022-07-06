package com.uknow.bestmoto.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uknow.bestmoto.presentation.fragment.cart.CartFragmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeFragmentViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeFragmentState())
    val uiState: StateFlow<HomeFragmentState> = _uiState

    fun fetchData() = viewModelScope.launch {

    }
}