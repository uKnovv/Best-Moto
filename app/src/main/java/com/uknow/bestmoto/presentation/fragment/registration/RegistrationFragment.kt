package com.uknow.bestmoto.presentation.fragment.registration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentRegistrationBinding
import com.uknow.bestmoto.model.LoginRequest
import com.uknow.bestmoto.model.RegisterRequest
import com.uknow.bestmoto.presentation.fragment.login.LoginFragmentState
import kotlinx.coroutines.flow.collect

class RegistrationFragment : Fragment(R.layout.fragment_registration), View.OnClickListener {

    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var viewModel: RegisterFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[RegisterFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)
        binding.run {
            btnSignIn.setOnClickListener(this@RegistrationFragment)
            fabCreateAccount.setOnClickListener(this@RegistrationFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { newState -> updateUI(newState) }
        }
    }

    private fun checkText(): RegisterRequest? {
        val login = binding.etEmail.text.toString().trim()
        val name = binding.etName.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        return if(TextUtils.isEmpty(login) || login.length >= 5) {
            binding.tfEmail.error = getString(R.string.error_email_is_too_short)
            null
        } else if(TextUtils.isEmpty(password) || password.length >= 5) {
            binding.tfEmail.error = getString(R.string.error_pass_is_too_short)
            null
        } else if (TextUtils.isEmpty(name)) {
            binding.tfName.error = getString(R.string.error_name_is_empty)
            null
        } else {
            RegisterRequest(
                login = login,
                password = password,
                name = name
            )
        }
    }

    private fun updateUI(state: RegisterFragmentState) {
        when(state) {
            else -> Unit
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.btnSignIn.id -> { navigateToSignIn() }
            binding.fabCreateAccount.id -> { checkText()?.let { request ->  viewModel.tryToRegister(request) } }
        }
    }

    private fun navigateToHome() {

    }

    private fun navigateToSignIn() {

    }
}