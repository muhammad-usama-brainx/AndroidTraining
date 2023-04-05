package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val todos: MutableList<Todo>,private var context:Context? ) : RecyclerView.Adapter<RecyclerAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.tvTodo)
        var checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.card_list_item,parent, false);
        return  TodoViewHolder(view);
    }

    override fun getItemCount(): Int {
        return  todos.size;
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.textView.text = todos[position].title;
        holder.checkBox.isChecked = todos[position].isDone;

        holder.checkBox.setOnClickListener {
            var toastMessage: String = "${holder.textView.text} is marked as Completed";

            if(!holder.checkBox.isChecked) {
                toastMessage = "${holder.textView.text} is marked as Pending";
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();

        }
    }
}