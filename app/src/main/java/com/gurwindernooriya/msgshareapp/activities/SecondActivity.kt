package com.gurwindernooriya.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.gurwindernooriya.msgshareapp.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


         val bundle :Bundle?=intent.extras
        val usermessage = bundle?.getString("user_message")

        val textview = findViewById<TextView>(R.id.user_mesg)
        textview.setText(usermessage)
    }
}