package com.example.sports_tracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.sports_tracker.R
import com.example.sports_tracker.databinding.FragmentSportBinding
import com.example.sports_tracker.viewModels.SportViewmodel

class SportFragment : Fragment() {

    private lateinit var binding: FragmentSportBinding

    private val viewModel:SportViewmodel by activityViewModels {
        SportViewmodel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sport, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel=viewModel
    }
}