package com.uknow.bestmoto.presentation.fragment.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)
    }

    companion object {

    }
}