package com.hordiiko.cfg.presentation.loadProducts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hordiiko.cfg.R
import com.hordiiko.cfg.databinding.FragmentLoadProductsBinding
import com.hordiiko.cfg.presentation.loadProducts.model.LoadProductsEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadProductsFragment : Fragment(R.layout.fragment_load_products) {

    private val viewModel: LoadProductsViewModel by viewModels()

    private var _binding: FragmentLoadProductsBinding? = null
    private val binding: FragmentLoadProductsBinding
        get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoadProductsBinding.bind(view)

        binding.viewModel = viewModel

        observeUiState()
        observeEvent()
    }

    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            binding.uiState = uiState
        }
    }

    private fun observeEvent() {
        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                LoadProductsEvent.LoadProductsSuccess ->
                    findNavController().navigate(
                        R.id.action_load_products_fragment_to_products_fragment
                    )
            }
        }
    }
}