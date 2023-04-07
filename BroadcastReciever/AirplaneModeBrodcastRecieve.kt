package com.example.firstapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeBroadcastReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return;

        var message = "Airplane mode disabled"

        if (isAirplaneModeEnabled)
            message = "Airplane mode enabled"

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}