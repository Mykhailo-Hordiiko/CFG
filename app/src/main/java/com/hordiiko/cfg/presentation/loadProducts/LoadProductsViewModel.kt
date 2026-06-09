package com.hordiiko.cfg.presentation.loadProducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hordiiko.cfg.domain.repository.ProductRepository
import com.hordiiko.cfg.presentation.loadProducts.model.LoadProductsEvent
import com.hordiiko.cfg.presentation.loadProducts.model.LoadProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableLiveData(LoadProductsUiState())
    val uiState: LiveData<LoadProductsUiState> = _uiState

    private val _event = MutableLiveData<LoadProductsEvent>()
    val event: LiveData<LoadProductsEvent> = _event

    fun onLoadProductsClick() {
        viewModelScope.launch {
            setLoading()

            try {
                productRepository.loadProducts()

                setSuccess()
                _event.value = LoadProductsEvent.LoadProductsSuccess
            } catch (exception: Exception) {
                setError(exception)
            }
        }
    }

    private fun setLoading() {
        _uiState.value = _uiState.value?.copy(
            errorMessage = null,
            isLoading = true
        )
    }

    private fun setSuccess() {
        _uiState.value = _uiState.value?.copy(
            isLoading = false
        )
    }

    private fun setError(exception: Exception) {
        _uiState.value = _uiState.value?.copy(
            errorMessage = exception.message,
            isLoading = false
        )
    }
}