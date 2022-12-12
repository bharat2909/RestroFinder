package com.example.restrofinder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restrofinder.R
import com.example.restrofinder.adapters.RestroAdapter
import com.example.restrofinder.ui.MainActivity
import com.example.restrofinder.viewmodels.RestroViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFragment:Fragment(R.layout.fragment_search) {

    lateinit var viewModel:RestroViewModel
    lateinit var restroAdapter: RestroAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        var job: Job?=null
        etSearch1.addTextChangedListener{query->

            job?.cancel()
            job = MainScope().launch {
                delay(500)
                query?.let {
                    if(query.toString().isNotEmpty()){
                        restroAdapter.differ.submitList(viewModel.searchRestaurant(query.toString()))
                    }
                }
            }


        }
    }

    private fun setUpRecyclerView(){
        restroAdapter = RestroAdapter()
        rvSearch.adapter = restroAdapter
        rvSearch.layoutManager = LinearLayoutManager(activity)
    }

}

