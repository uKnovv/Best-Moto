package com.uknow.bestmoto.presentation.fragment.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartFragmentViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(CartFragmentState())
    val uiState: StateFlow<CartFragmentState> = _uiState

    fun fetchPurchases() = viewModelScope.launch {

    }
}