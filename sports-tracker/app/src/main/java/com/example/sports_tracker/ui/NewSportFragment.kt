package com.example.sports_tracker.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sports_tracker.R
import com.example.sports_tracker.databinding.FragmentNewSportBinding
import com.example.sports_tracker.viewModels.SportViewmodel

class NewSportFragment : Fragment() {

    private lateinit var binding: FragmentNewSportBinding

    private val viewModel:SportViewmodel by activityViewModels() {
        SportViewmodel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_sport,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerSport(      )
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    companion object{
        const val APP_TAG = "APP_TAG"
    }

    private fun observerSport(){
        viewModel.status.observe(viewLifecycleOwner){status->
            when{
                status.equals(SportViewmodel.WRONG_INFORMATION)->{
                    Log.d(APP_TAG,status)
                }
                status.equals(SportViewmodel.SPORT_CREATED)->{
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, viewModel.getSport().toString())

                    viewModel.clearstatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}