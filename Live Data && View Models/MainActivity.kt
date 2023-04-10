package com.example.firstapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val countObserver = Observer<Int> { newValue ->
            binding.tvCounter.text = newValue.toString()
        }

        viewModel.counter.observe(this, countObserver)

        binding.btnAdd.setOnClickListener {
            viewModel.add()
        }

    }
}