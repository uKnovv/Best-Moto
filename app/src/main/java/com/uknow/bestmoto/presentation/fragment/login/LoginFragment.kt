package com.uknow.bestmoto.presentation.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
    }

    companion object {

    }
}