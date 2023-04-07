package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private lateinit var handler: Handler;
    private var count: Int = 0;
    private var run = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        handler = Handler(applicationContext.mainLooper);

        binding.btnStart.setOnClickListener {
            clickListener(it);
        }

        binding.btnStop.setOnClickListener {
            clickListener(it);
        }
    }

    private fun clickListener(view: View) {

        when (view.id) {
            R.id.btnStart -> {
                CountThread().start();
            }
            R.id.btnStop -> {
                run = false
            }
        }
    }

    inner class CountThread : Thread() {
        override fun run() {
            super.run()
            run = true
            while (run) {
                Thread.sleep(1000)
                count++
                println("Thread id ${Thread.currentThread().id}, Count $count")
                handler.post(Runnable {
                    kotlin.run {
                        binding.tvCount.text = count.toString();
                    }
                })
            }
        }
    }
}