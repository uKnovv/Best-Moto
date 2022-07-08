package com.uknow.bestmoto.presentation.fragment.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentLoginBinding
import com.uknow.bestmoto.model.LoginRequest

class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.run {
            fabLogin.setOnClickListener(this@LoginFragment)
            btnForgotPass.setOnClickListener(this@LoginFragment)
            btnCreateAccount.setOnClickListener(this@LoginFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { newState -> updateUI(newState) }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.fabLogin.id -> { checkText()?.let { request -> viewModel.tryToLogin(request) } }
            binding.btnForgotPass.id -> { navigateToForgotPass() }
            binding.btnCreateAccount.id -> { navigateToRegister() }
            else -> Unit
        }
    }

    private fun checkText(): LoginRequest? {
        val login = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        return if(TextUtils.isEmpty(login) || login.length >= 5) {
            binding.tfEmail.error = getString(R.string.error_email_is_too_short)
            null
        } else if(TextUtils.isEmpty(password) || password.length >= 5) {
            binding.tfEmail.error = getString(R.string.error_pass_is_too_short)
            null
        } else {
            LoginRequest(
                login = login,
                password = password
            )
        }
    }

    private fun updateUI(state: LoginFragmentState) {
        when(state) {
            else -> Unit
        }
    }

    private fun navigateToForgotPass() {

    }

    private fun navigateToRegister() {

    }

    private fun navigateToHome() {

    }
}