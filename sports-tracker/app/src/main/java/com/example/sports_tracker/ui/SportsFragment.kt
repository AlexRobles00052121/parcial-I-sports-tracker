package com.example.sports_tracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sports_tracker.R
import com.example.sports_tracker.adapter.SportAdapter
import com.example.sports_tracker.data.Sport
import com.example.sports_tracker.databinding.FragmentSportsBinding
import com.example.sports_tracker.viewModels.SportViewmodel


class SportsFragment : Fragment() {

    private lateinit var binding: FragmentSportsBinding
    private lateinit var adapter:SportAdapter

    private val viewModel:SportViewmodel by activityViewModels {
        SportViewmodel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sports,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
        setRecyclerView(view)
    }

    private fun listeners() {
        binding.btnNew.setOnClickListener{
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_sportsFragment_to_newSportFragment)
        }
    }

    private fun showSelectedItem(sport: Sport){
        viewModel.setselectSport(sport)
        findNavController().navigate(R.id.action_sportsFragment_to_sportFragment)
    }

    private fun displayItem(){
        adapter.setData(viewModel.getSport())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.recicler.layoutManager = LinearLayoutManager(view.context)

        adapter  = SportAdapter {selectedSport->
            showSelectedItem(selectedSport)
        }

        binding.recicler.adapter = adapter
        displayItem()
    }
}