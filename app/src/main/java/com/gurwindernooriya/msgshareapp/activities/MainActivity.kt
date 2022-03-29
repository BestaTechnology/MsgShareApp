package com.gurwindernooriya.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.gurwindernooriya.msgshareapp.R
import com.gurwindernooriya.msgshareapp.extensions.showToast
import com.gurwindernooriya.msgshareapp.myutil.ApConstants

/*
* we will learn about intent
* explicit intent
* implicit intent
* share data by intent
*
* */


class MainActivity : AppCompatActivity() {



    /*it can be declared only within class
    * it acts like static class in java to access its members
    * */

    companion object {
        val TAGD:String="myobject"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar:Toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu1)
//        toolbar.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->Menu  })


        val textview  = findViewById<EditText>(R.id.et_msg)
        val sendbtn = findViewById<Button>(R.id.sendbtn)
        val recyclerdemobtn = findViewById<Button>(R.id.recycler_btn)

        val usermessage =textview.text.toString()

        sendbtn.setOnClickListener {

            //using extension function , and passing toast length , however it is not necessary
            showToast(usermessage,Toast.LENGTH_LONG)
            Log.d(TAGD, "onCreate: "+usermessage)
            // this is called explicit intent when we know the target activity
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(ApConstants.USER_MESSAGE,textview.text.toString())
            startActivity(intent)

        }

        val sharedata =findViewById<Button>(R.id.share_btn)


        //implicit intent when we dont know the target activity in that case
        // we need to create user with action type , settype etc.
        sharedata.setOnClickListener {
            Log.d(TAGD, "share data: ")
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,textview.text.toString())
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Please Select App"))
        }

        recyclerdemobtn.setOnClickListener{
            val intent = Intent(this,HobbiesActivity::class.java)
            startActivity(intent)
        }

    }

    fun showmessage(view: android.view.View)
    {Toast.makeText(this,"Working fine",Toast.LENGTH_SHORT).show()}
}