package com.example.firstapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class NewFragment  : Fragment(){

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("Fragment On Attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Fragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("Fragment onCreateView")
        return inflater.inflate(R.layout.new_fragment,container,false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Fragment onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        println("Fragment onStart")
    }

    override fun onResume() {
        super.onResume()
        println("Fragment onResume")
    }

    override fun onPause() {
        super.onPause()
        println("Fragment onPause")
    }

    override fun onStop() {
        super.onStop()
        println("Fragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("Fragment onDestroyView")
    }
}