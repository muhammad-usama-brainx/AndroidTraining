package com.example.firstapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var reciever: AirplaneModeBroadcastReciever

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //Implementing in onStart so we can register again after on stop
    override fun onStart() {
        super.onStart()
        reciever = AirplaneModeBroadcastReciever();

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(reciever, it)
        }
    }

    override fun onStop() {
        super.onStop()
        println("On stop")
        unregisterReceiver(reciever)
    }
}