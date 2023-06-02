package com.example.sports_tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sports_tracker.data.Sport
import com.example.sports_tracker.databinding.ItemSportBinding

class SportAdapter(private val Click:(Sport)->Unit): RecyclerView.Adapter<SportAdapter.ViewHolderSport>() {

    private var sports:List<Sport>?=null

    class ViewHolderSport(private val binding:ItemSportBinding ): RecyclerView.ViewHolder(binding.root){

        fun bind(sport: Sport, Click:(Sport)->Unit){
            binding.textNameSportCarview.text = sport.name

            binding.cardviewName.setOnClickListener {
                Click(sport)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSport {
        val binding = ItemSportBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderSport(binding)
    }

    override fun getItemCount(): Int = sports?.size ?: 0


    override fun onBindViewHolder(holder: ViewHolderSport, position: Int) {

        sports?.let {
            holder.bind(it[position], Click) }
    }

    fun setData(sports:List<Sport>){
        this.sports = sports
        notifyDataSetChanged()
    }
}