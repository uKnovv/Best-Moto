package com.uknow.bestmoto.presentation.fragment.login

data class LoginFragmentState(
    val isLoading: Boolean? = false,
    val error: String? = null,
    val data: Any? = null,
)