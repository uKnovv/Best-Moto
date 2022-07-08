package com.uknow.bestmoto.presentation.fragment.profile

data class ProfileFragmentState(
    val isLoading: Boolean? = false,
    val error: String? = null,
    val data: Any? = null,
)