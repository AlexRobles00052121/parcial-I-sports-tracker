package com.example.sports_tracker.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sports_tracker.SportApp
import com.example.sports_tracker.data.Sport
import com.example.sports_tracker.repositories.SportRepository

class SportViewmodel(private val sportRepository: SportRepository):ViewModel(){

    val name = MutableLiveData("")
    val deporte = MutableLiveData("")
    val status = MutableLiveData("")

    fun getSport()=sportRepository.getSport()
    private fun addSport(sport: Sport) = sportRepository.addSport(sport)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val viewsport = (this[APPLICATION_KEY] as SportApp).sportRepository
                SportViewmodel(viewsport)
            }
        }

        const val SPORT_CREATED = "Sport created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }

    private fun validatData():Boolean{
        when{
            name.value.isNullOrEmpty()->return false
            deporte.value.isNullOrEmpty()->return false
        }
        return true
    }

    fun createSport(){
        if(!validatData()){
            status.value = WRONG_INFORMATION
            return
        }

        val sport = Sport(
            name.value!!,
            deporte.value!!,
        )

        addSport(sport)
        clearData()
        status.value = SPORT_CREATED
    }

    fun clearData() {
        name.value = ""
        deporte.value=""
    }

    fun clearstatus(){
        status.value= INACTIVE
    }

    fun setselectSport(sport: Sport){
        name.value=sport.name
        deporte.value=sport.deporte
    }
}