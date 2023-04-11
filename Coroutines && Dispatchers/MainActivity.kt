package com.example.firstapp


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var fbFollowersCount = 0
    private var instagramFollowersCount = 0

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val fbResponse = async {
                getFbFollowers()
            }

            val instagramResponse = async {
                getInstagramFollowers()
            }
            
            println("Instagram followers are ${instagramResponse.await()}")
            println("Facebook followers are ${fbResponse.await()}")
        }
    }

    private suspend fun getFbFollowers(): Int {
        delay(6000)
        return 67
    }

    private suspend fun getInstagramFollowers(): Int {
        delay(3000)
        return 2323
    }

}