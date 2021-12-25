package com.example.my5lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.View
import java.util.concurrent.TimeUnit
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var linearLayout: LinearLayout? = null
    lateinit var context: Context
    var counter = 0
//    var textView = TextView(context)
    val LOG_TAG: String? = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate");
//        retainInstance = true
        context = this
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.MyText)


        MyAsyncTask().execute()
    }

    inner class MyAsyncTask() : AsyncTask<Void, Void, Void>() {

        // counter
        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate()
            var textView = TextView(context)
            counter++
            textView.setText("Мой $counter элемент")
            linearLayout?.addView(textView)

        }

        override fun doInBackground(vararg p0: Void?): Void? {
            for (i in 1..8) {
                TimeUnit.SECONDS.sleep(1)
                publishProgress()
            }
            return null
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(LOG_TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

}