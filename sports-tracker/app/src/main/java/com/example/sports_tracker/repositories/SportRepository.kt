package com.example.sports_tracker.repositories

import com.example.sports_tracker.data.Sport

class SportRepository (private var sports: MutableList<Sport>){
     fun getSport()= sports
    fun addSport(sport: Sport)= sports.add(sport)
}


