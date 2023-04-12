package com.example.levelup


import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.levelup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRequestPermission.setOnClickListener {
            requestPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 0 && grantResults.isNotEmpty())
        {
            for(i in grantResults.indices)
            {
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED)
                {
                    Log.d("PermissionRequest", "${permissions[i]} is granted")
                }
            }
        }
    }

   private fun isForeGroundPermissionAccepted() =
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED


   private fun isBackGroundPermissionAccepted() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_BACKGROUND_LOCATION) ==
                PackageManager.PERMISSION_GRANTED

  private  fun requestPermission() {
        val permissionsToRequest = mutableListOf<String>()


        if(!isBackGroundPermissionAccepted())
        {
            permissionsToRequest.add(android.Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if(!isForeGroundPermissionAccepted())
        {
            permissionsToRequest.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if(permissionsToRequest.isNotEmpty())
        {
            ActivityCompat.requestPermissions(this,permissionsToRequest.toTypedArray(),0)
        }
    }
}