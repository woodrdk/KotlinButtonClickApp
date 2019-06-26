package com.woodrdk.kotlinbuttonclickapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.ActionMode
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"
class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.editText)
        val button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        userInput.setText("")
        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?){
                textView?.append(userInput.text)
                textView?.append("\n")
                //userInput.text.clear()
                userInput.setText("")
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
//      val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "")
//      textView?.text = savedString
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }
}
