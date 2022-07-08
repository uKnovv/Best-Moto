package com.uknow.bestmoto.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uknow.bestmoto.usecase.GetGoodsUseCase
import com.uknow.bestmoto.util.Resource
import com.uknow.bestmoto.util.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getBikesListUseCase: GetGoodsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeFragmentState())
    val uiState: StateFlow<HomeFragmentState> = _uiState

    init {
        fetchData()
    }

    fun fetchData() = viewModelScope.launch {
        getBikesListUseCase.invoke().collect { resource ->
            when (resource) {
                is Resource.Success -> {
//                    _uiState.update { state ->
//                        state.copy(
//                            data_bikes = resource.data
//                        )
//                    }
                }
                is Resource.Error -> {
                    _uiState.update { state ->
                        state.copy(
                            error = resource.message
                        )
                    }
                }
                is Resource.Loading -> {
                    _uiState.update { state ->
                        state.copy(
                            isLoading = resource.isLoading
                        )
                    }
                }
                else -> Unit
            }
        }
    }
}