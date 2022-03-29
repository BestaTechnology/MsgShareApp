package com.gurwindernooriya.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.gurwindernooriya.msgshareapp.R
import com.gurwindernooriya.msgshareapp.myutil.ApConstants

class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG:String=SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /* Safe call ?.
        * Safe call with let ?. let {}
        * */
         val bundle :Bundle?=intent.extras

        /*to avoid null pointer exception*/
        bundle?.let {
            val usermessage = bundle.getString(ApConstants.USER_MESSAGE)
            val textview = findViewById<TextView>(R.id.user_mesg)
            textview.text = usermessage
        }

    }
}