package com.hordiiko.cfg.presentation.editProduct

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hordiiko.cfg.R
import com.hordiiko.cfg.databinding.FragmentEditProductBinding
import com.hordiiko.cfg.presentation.editProduct.model.EditProductEvent
import com.hordiiko.cfg.presentation.navigation.PRODUCT_ID_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProductFragment : Fragment(R.layout.fragment_edit_product) {

    private val viewModel: EditProductViewModel by viewModels()

    private var _binding: FragmentEditProductBinding? = null
    private val binding: FragmentEditProductBinding
        get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentEditProductBinding.bind(view)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        observeEvent()

        loadProduct()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun observeEvent() {
        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                EditProductEvent.EditProductSuccess ->
                    findNavController().navigateUp()
            }
        }
    }

    private fun loadProduct() {
        viewModel.loadProduct(
            requireArguments().getLong(PRODUCT_ID_KEY)
        )
    }
}