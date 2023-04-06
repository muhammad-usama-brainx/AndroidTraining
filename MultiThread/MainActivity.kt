package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val firstThreadUsingClass = MyThread();
        val secondThreadUsingClass = MyThread();

        firstThreadUsingClass.start();
        secondThreadUsingClass.start();

        val firstThreadUsingRunnable = Thread(MyRunnable());
        val secondThreadUsingRunnable = Thread(MyRunnable());

        firstThreadUsingRunnable.start();
        secondThreadUsingRunnable.start();

    }
}

class MyRunnable : Runnable {
    override fun run() {
        println("Thread " + Thread.currentThread().id)
    }
}

class MyThread : Thread() {
    override fun run() {
        println("Thread " + Thread.currentThread().id)
    }
}