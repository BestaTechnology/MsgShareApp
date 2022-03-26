package com.gurwindernooriya.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gurwindernooriya.msgshareapp.R
import com.gurwindernooriya.msgshareapp.dataclasses.Hobby
import com.gurwindernooriya.msgshareapp.dataclasses.Supplier.hobbies

class HobbiesAdapter (val context :Context,val hobbylist:List<Hobby>): RecyclerView.Adapter<HobbiesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesAdapter.ViewHolder {
        val view  =LayoutInflater.from(context).inflate(R.layout.list_hobbies,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HobbiesAdapter.ViewHolder, position: Int) {
        val hobbies =hobbylist.get(position)
        holder.setData(hobbies,position)
        


    }



    override fun getItemCount(): Int {
        return hobbylist.size
    }

    inner  class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

        val textview = itemview.findViewById<TextView>(R.id.title_tv)
        val sharebtn = itemview.findViewById<ImageView>(R.id.image_iv)

        var currenthobby:Hobby?=null
        var currentposition:Int=0




        init {
            textview.setOnClickListener {
                Toast.makeText(context, currenthobby!!.title +"is clicked on position"+currentposition,Toast.LENGTH_SHORT).show()
            }

            sharebtn.setOnClickListener {
                val intent = Intent()
                intent.action=Intent.ACTION_SEND
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, currenthobby?.title)
                context.startActivity(Intent.createChooser(intent,"Share Hobby"))
            }

        }

        fun  setData(hobby: Hobby?, position: Int){
            textview.setText(hobby!!.title)
            this.currenthobby=hobby
            this.currentposition=position
        }
    }

}