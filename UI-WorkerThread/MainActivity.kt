package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..100)
        {
            println("Running using Thread ${Thread.currentThread().id}")
        }

        val workerThread = MyThread();
        workerThread.start();
    }
}

class MyThread:  Thread() {
    override fun run() {
        super.run()
        for (i in 1..100)
        {
            println("Running using Thread ${Thread.currentThread().id}")
        }
    }

    fun perform(operation: () -> Unit) {
        operation();
    }
}