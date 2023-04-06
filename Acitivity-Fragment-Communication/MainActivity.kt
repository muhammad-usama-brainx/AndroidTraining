package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.Fragment

class MainActivity :  AppCompatActivity(){
   private val viewModel: MainActivityViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.btnIncrement);

        val btnFirstFragment: Button = findViewById(R.id.btnFragment1);
        val btnSecondFragment: Button = findViewById(R.id.btnFragment2);

        val firstFragment = FirstFragment();
        val secondFragment = SecondFragment();
        replaceFragment(firstFragment, "first");

        firstFragment.arguments = Bundle().apply {
            this.putString("name", "Usama Javed");
        };

        btnAdd.setOnClickListener {
            viewModel.increaseNumber();
        }

        btnFirstFragment.setOnClickListener {
            replaceFragment(firstFragment, "first")
        }

        btnSecondFragment.setOnClickListener {
            replaceFragment(secondFragment, "second");
        }
    }

   private fun replaceFragment(fragment: Fragment, tag: String)
    {
        val fragmentManager = supportFragmentManager;
        val fragmentTransaction = supportFragmentManager.beginTransaction().also {
            it.replace(R.id.frameContainer, fragment, tag);
            it.commit();
        };
    }
}