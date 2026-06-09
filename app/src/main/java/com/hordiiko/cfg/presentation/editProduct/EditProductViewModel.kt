package com.hordiiko.cfg.presentation.editProduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hordiiko.cfg.domain.model.Product
import com.hordiiko.cfg.domain.repository.ProductRepository
import com.hordiiko.cfg.presentation.editProduct.model.EditProductEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private var productId: Long? = null

    val name: MutableLiveData<String> = MutableLiveData("")
    val description: MutableLiveData<String> = MutableLiveData("")

    private val _event = MutableLiveData<EditProductEvent>()
    val event: LiveData<EditProductEvent> = _event

    fun loadProduct(id: Long) {
        if (productId != null) return
        productId = id

        viewModelScope.launch {
            val product: Product = productRepository.getProductById(id)
                ?: return@launch

            name.value = product.name
            description.value = product.description
        }
    }

    fun onSaveProductClick() {
        val id: Long = productId ?: return

        viewModelScope.launch {
            productRepository.updateProduct(
                id = id,
                name = name.value.orEmpty(),
                description = description.value.orEmpty()
            )

            _event.value = EditProductEvent.EditProductSuccess
        }
    }
}