package com.example.firstapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    private var progressBar: ProgressBar? = null
    private var btnStart: Button? = null
    private var myAsyncTask: MyAsyncTask? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btnStart);
        myAsyncTask = MyAsyncTask(this);

        btnStart?.setOnClickListener {
            startTask();
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myAsyncTask?.cancel(false);
    }

    fun startTask() {
        myAsyncTask?.execute(10);
    }


    inner class MyAsyncTask(val mainActivity: MainActivity) : AsyncTask<Int, Int, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar?.visibility = View.VISIBLE;
        }

        override fun doInBackground(vararg p0: Int?): String {
            for (i in 1..p0[0]!!) {
                publishProgress((i * 100) / p0[0]!!);
                Thread.sleep(1000);
            }

            return "Finished";
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            progressBar?.progress = values[0]!!;
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressBar?.progress = 0;
            progressBar?.visibility = View.INVISIBLE;
            Toast.makeText(mainActivity, result, Toast.LENGTH_SHORT).show();
        }
    }
}