package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostRecyclerViewAdapter(private val posts: List<Post>, private val context: Context) :
    RecyclerView.Adapter<PostRecyclerViewAdapter.PostViewHolder>() {

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.textViewId)
        val textViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val textViewBody: TextView = view.findViewById(R.id.textViewBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.textViewId.text = posts[position].id.toString()
        holder.textViewTitle.text = posts[position].title
        holder.textViewBody.text = posts[position].body
    }

}