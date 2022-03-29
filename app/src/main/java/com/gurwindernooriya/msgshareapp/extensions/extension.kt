package com.gurwindernooriya.msgshareapp.extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast

/*
* Context is the super class of activity
* That is why we are calling it by Context instead of Activity
* so that we can use these functions in adapters as well
* */


/*
showing
* default param in show toast fun
* */

fun Context.showToast(message:String,duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()


//    both calling are fine as we are using the default param property
    defaultparm()
    defaultparm(20)
}

fun defaultparm(a:Int=5){

}