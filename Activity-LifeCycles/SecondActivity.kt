package com.example.firstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: Button = findViewById(R.id.button2);
        button.setOnClickListener{
            finish();
        }
        println("Second Activity On Create Method");
    }

    override fun onStart() {
        super.onStart()
        println("Second Activity On Start Method");
    }

    override fun onRestart() {
        super.onRestart()
        println("Second Activity On Restart Method");
    }

    override fun onResume() {
        super.onResume()
        println("Second Activity On Resume Method");
    }

    override fun onPause() {
        super.onPause()
        println("Second Activity On Pause Method");
    }

    override fun onStop() {
        super.onStop()
        println("Second Activity On Stop Method");
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Second Activity On Destroy Method");
    }
}