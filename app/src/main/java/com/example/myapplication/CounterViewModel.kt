package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var likeCount: Int = 0

    init{
        Log.d("ViewModel", "ViewModel created")
    }

    fun incrementLike(){
        likeCount++
    }

    override fun onCleared(){
        Log.d("ViewModel", "ViewModel destroyed")
        super.onCleared()
    }
}