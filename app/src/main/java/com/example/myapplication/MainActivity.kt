package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Module-level variable
    //var like: Int = 0;
    var dislike: Int = 0;
    lateinit var counterViewModel: CounterViewModel
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            Log.d("MainActivity", "onCreate")

            //Initialize the counterViewModel
        counterViewModel = ViewModelProviders.of(this)
            .get(CounterViewModel::class.java)

        //Initialize the shared preferences
        sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE)
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)


            imageViewLike.setOnClickListener(){
                counterViewModel.incrementLike()
                textViewLike.text = counterViewModel.likeCount.toString()
            }

            imageViewDislike.setOnClickListener(){
                dislike++
                textViewDislike.text = dislike.toString()
            }
        }

        override fun onStart(){
            Log.d("MainActivity", "onStart")
            super.onStart()
        }

        override fun onResume(){
            Log.d("MainActivity", "onResume")
            val like = sharedPreferences.getInt(getString(R.string.like), 0)
            counterViewModel.likeCount = like

            textViewLike.text = counterViewModel.likeCount.toString()
            textViewDislike.text = dislike.toString()
            super.onResume()
        }

        override fun onPause(){
            Log.d("MainActivity", "onPause")
            with(sharedPreferences.edit()){
                putInt(getString(R.string.like), counterViewModel.likeCount)
                apply()
            }
            super.onPause()
        }

        override fun onStop() {
            Log.d("MainActivity", "onStop")
            super.onStop()
        }

        override fun onDestroy() {
            Log.d("MainActivity", "onDestroy")
            super.onDestroy()
        }
}
