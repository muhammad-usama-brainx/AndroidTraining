package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSecondActivity: Button = findViewById(R.id.btnSecondActivity);

      val reg =  registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {activityResult ->
                if(activityResult.resultCode == RESULT_OK)
                {
                    val data = activityResult.data;
                    println(data?.getStringExtra("name"));
                }
            });

        btnSecondActivity.setOnClickListener {
          Intent(this, SecondActivity::class.java).also {
              reg.launch(it);
          }

        }
    }
}