package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnGoBack: Button = findViewById(R.id.btnGoBack)

        btnGoBack.setOnClickListener {
            val intent = Intent();

            intent.putExtra("name", "Usama Javed");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}