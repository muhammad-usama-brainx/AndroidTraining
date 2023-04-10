package com.example.firstapp

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CountService : Service() {
    private var count = 0
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread(Runnable {
            kotlin.run {
                println("Started Count Service")

                while (count != 10) {
                    count++
                    println("$count ")
                    Thread.sleep(1000)
                }

                println("Destroying Count Service")
                stopSelf()
            }
        }).start()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        println("in OnDestroy Method")
        super.onDestroy()
    }
}