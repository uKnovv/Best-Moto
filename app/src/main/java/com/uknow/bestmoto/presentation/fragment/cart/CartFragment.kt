package com.uknow.bestmoto.presentation.fragment.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentCartBinding

class CartFragment : Fragment(R.layout.fragment_cart), View.OnClickListener {

    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartBinding.bind(view)
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