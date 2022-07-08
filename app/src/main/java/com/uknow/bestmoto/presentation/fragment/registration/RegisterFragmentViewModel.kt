package com.uknow.bestmoto.presentation.fragment.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uknow.bestmoto.model.RegisterRequest
import com.uknow.bestmoto.presentation.fragment.profile.ProfileFragmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterFragmentViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(RegisterFragmentState())
    val uiState: StateFlow<RegisterFragmentState> = _uiState

    fun tryToRegister(registerRequest: RegisterRequest) = viewModelScope.launch {

    }

}