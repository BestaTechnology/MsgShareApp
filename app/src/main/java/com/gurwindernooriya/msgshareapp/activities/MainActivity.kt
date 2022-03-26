package com.gurwindernooriya.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gurwindernooriya.msgshareapp.R

/*
* we will learn about intent
* explicit intent
* implicit intent
* share data by intent
*
* */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview  = findViewById<EditText>(R.id.et_msg)
        val sendbtn = findViewById<Button>(R.id.sendbtn)
        val recyclerdemobtn = findViewById<Button>(R.id.recycler_btn)

        var usermessage:String=""
        usermessage = textview.text.toString()

        sendbtn.setOnClickListener {
            Toast.makeText(this,usermessage,Toast.LENGTH_LONG).show()

            // this is called explicit intent when we know the target activity
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message",textview.text.toString())
            startActivity(intent)

        }

        val sharedata =findViewById<Button>(R.id.share_btn)


        //implicit intent when we dont know the target activity in that case
        // we need to create user with action type , settype etc.
        sharedata.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,textview.text.toString())
            intent.setType("text/plain")
            startActivity(Intent.createChooser(intent,"Please Select App"))
        }

        recyclerdemobtn.setOnClickListener{
            val intent = Intent(this,HobbiesActivity::class.java)
            startActivity(intent)
        }

    }
}