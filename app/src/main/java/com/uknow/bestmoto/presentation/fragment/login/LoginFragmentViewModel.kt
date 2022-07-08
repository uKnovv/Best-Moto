package com.uknow.bestmoto.presentation.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uknow.bestmoto.model.LoginRequest
import com.uknow.bestmoto.presentation.fragment.home.HomeFragmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginFragmentViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginFragmentState())
    val uiState: StateFlow<LoginFragmentState> = _uiState

    fun tryToLogin(loginRequest: LoginRequest) = viewModelScope.launch {

    }
}