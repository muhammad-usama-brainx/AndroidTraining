package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity :  AppCompatActivity(){

   private val todos = mutableListOf<Todo>(
       Todo("Learn Android", false),
       Todo("Learn ListView and RecyclerView", true),
       Todo("Learn Layouts (Linear && Constraint && Relative && Motion)", true)
   );
    private var adapter: RecyclerAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddTodo:Button = findViewById(R.id.btnAddTodo);
        val editTextTodo: EditText = findViewById(R.id.etTodo);
        val recyclerView: RecyclerView = findViewById(R.id.rvTodo);

        adapter = RecyclerAdapter(todos, this);

        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = adapter;

        btnAddTodo.setOnClickListener {
            val enteredText = editTextTodo.text.toString();
            editTextTodo.text.clear();

            if(enteredText.isNotEmpty())
            {
                todos.add(Todo(enteredText, false));
                adapter?.notifyItemChanged(todos.size - 1);
            }
        }
    }
}