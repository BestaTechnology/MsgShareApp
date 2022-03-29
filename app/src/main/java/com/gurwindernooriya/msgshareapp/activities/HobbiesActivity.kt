package com.gurwindernooriya.msgshareapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gurwindernooriya.msgshareapp.R
import com.gurwindernooriya.msgshareapp.adapters.HobbiesAdapter
import com.gurwindernooriya.msgshareapp.dataclasses.Supplier

class HobbiesActivity : AppCompatActivity() {

    companion object{
        val TAG:String=HobbiesActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)


        setRecyclerview()

    }

    private fun setRecyclerview() {
        val recyclerview =findViewById<RecyclerView>(R.id.recycler_hobbies)
        val linearlayout = LinearLayoutManager(this)
        linearlayout.orientation=LinearLayoutManager.VERTICAL
        recyclerview.layoutManager=linearlayout
        val  adapter =HobbiesAdapter(this, Supplier.hobbies)
        recyclerview.adapter=adapter
    }
}