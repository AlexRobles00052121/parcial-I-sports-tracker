package com.example.sports_tracker

import android.app.Application
import com.example.sports_tracker.data.sports
import com.example.sports_tracker.repositories.SportRepository

class SportApp: Application() {

    val sportRepository: SportRepository by lazy {
        SportRepository(sports)
    }
}