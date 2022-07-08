package com.uknow.bestmoto.presentation.fragment.registration

data class RegisterFragmentState(
    val isLoading: Boolean? = false,
    val error: String? = null,
    val data: Any? = null,
)