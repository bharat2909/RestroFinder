package com.example.restrofinder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.restrofinder.R
import com.example.restrofinder.ui.MainActivity
import com.example.restrofinder.viewmodels.RestroViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment:Fragment(R.layout.fragment_home) {

    lateinit var viewModel:RestroViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

    etSearch.setOnClickListener{
        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
    }


    }

}