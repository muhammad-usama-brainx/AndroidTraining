package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity :  AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("First Activity On Create Method");
    }

    override fun onStart() {
        super.onStart()
        println("First Activity On Start Method");
    }

    override fun onRestart() {
        super.onRestart()
        println("First Activity On Restart Method");
    }

    override fun onResume() {
        super.onResume()
        println("First Activity On Resume Method");
    }

    override fun onPause() {
        super.onPause()
        println("First Activity On Pause Method");
    }

    override fun onStop() {
        super.onStop()
        println("First Activity On Stop Method");
    }

    override fun onDestroy() {
        super.onDestroy()
        println("First Activity On Destroy Method");
    }
}