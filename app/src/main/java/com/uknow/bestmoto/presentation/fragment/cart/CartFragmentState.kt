package com.uknow.bestmoto.presentation.fragment.cart

import com.uknow.bestmoto.model.Purchase

data class CartFragmentState(
    val isLoading: Boolean? = false,
    val error: String? = null,
    val data: List<Purchase>? = null
)
