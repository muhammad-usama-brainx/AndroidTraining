package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class MainActivity :  AppCompatActivity(){
   private val countries: MutableList<String> = mutableListOf<String>();
    var adapter: ArrayAdapter<String>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countries.add("Pakistan");
        countries.add("India");
        countries.add("Germany");
        countries.add("USA");
        countries.add("UK");
        countries.add("Spain");
        countries.add("Turkey");
        countries.add("Iran");
        countries.add("Iraq");
        countries.add("Saudia");
        countries.add("Russia");
        countries.add("Dubai");
        countries.add("Bangladesh");
        countries.add("Srilanka");
        countries.add("Zimbawae");
        countries.add("Namibia");

        val listView: ListView = findViewById(R.id.ltCountries);
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,countries);
        listView.adapter = adapter;
    }
}