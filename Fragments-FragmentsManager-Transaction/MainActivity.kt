package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment


class MainActivity :  AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeFragmentButton: Button = findViewById(R.id.changeFragment);

        val firstFragment =FragmentOne();
        val secondFragment = FragmentTwo();
        replaceFragment(firstFragment, "first");

        changeFragmentButton.setOnClickListener {
           val isFirstFragment = supportFragmentManager.findFragmentByTag("first").let {
                it != null && it.isVisible;
           };

            if(isFirstFragment)
                replaceFragment(secondFragment,"second");
            else
                replaceFragment(firstFragment,"first");
        }
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
       val fragmentManager = supportFragmentManager;
        val fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragmentContainer,fragment,tag);
        fragmentTransaction.commit();
    }
}