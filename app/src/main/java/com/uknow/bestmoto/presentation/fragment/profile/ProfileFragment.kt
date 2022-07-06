package com.uknow.bestmoto.presentation.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uknow.bestmoto.R
import com.uknow.bestmoto.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
    }

    companion object {

    }
}