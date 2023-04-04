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

        val pushActivityButton: Button = findViewById(R.id.push);
        val replaceActivityButton: Button = findViewById(R.id.replace);

        //Push new activity on the activity stack
        //Can remove the pushed activity to came back to this activity
        pushActivityButton.setOnClickListener{
            Intent(this, SecondActivity::class.java).also {
                startActivity(it);
            }
        }

        //Will push the new activity and closes current activity
        //Cannot pop and came back to this activity
        replaceActivityButton.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it);
                this.finish();
            }
        }
    }
}