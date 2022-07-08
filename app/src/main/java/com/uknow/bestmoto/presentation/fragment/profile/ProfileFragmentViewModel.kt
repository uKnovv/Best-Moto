package com.uknow.bestmoto.presentation.fragment.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uknow.bestmoto.model.RegisterRequest
import com.uknow.bestmoto.presentation.fragment.home.HomeFragmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileFragmentViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(ProfileFragmentState())
    val uiState: StateFlow<ProfileFragmentState> = _uiState

    fun fetchData(registerRequest: RegisterRequest) = viewModelScope.launch {

    }
}