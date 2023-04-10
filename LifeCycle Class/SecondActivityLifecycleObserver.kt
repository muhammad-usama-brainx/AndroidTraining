package com.example.firstapp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class SecondActivityLifecycleObserver : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun onCreate() {
        println("Second Activity Created")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroy() {
        println("Second Activity Destroyed")
    }
}