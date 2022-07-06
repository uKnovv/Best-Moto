package com.uknow.bestmoto.presentation.fragment.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentCartBinding
import kotlinx.coroutines.flow.collect

class CartFragment : Fragment(R.layout.fragment_cart), View.OnClickListener {

    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CartFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartBinding.bind(view)
        binding.run {
            fabPay.setOnClickListener(this@CartFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { newState ->
                updateUI(newState)
            }
        }
    }

    private fun updateUI(state: CartFragmentState) {

    }

    private fun clearAndUpdateRecycler() {

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.fabPay.id -> {
                Toast.makeText(requireContext(), "Navigation to payment", Toast.LENGTH_SHORT).show()
            }
        }
    }
}