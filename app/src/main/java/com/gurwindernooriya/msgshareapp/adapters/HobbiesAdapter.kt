package com.gurwindernooriya.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gurwindernooriya.msgshareapp.R
import com.gurwindernooriya.msgshareapp.activities.SecondActivity
import com.gurwindernooriya.msgshareapp.dataclasses.Hobby
import com.gurwindernooriya.msgshareapp.extensions.showToast

class HobbiesAdapter (val context :Context, private val hobbyist:List<Hobby>): RecyclerView.Adapter<HobbiesAdapter.ViewHolder>() {
    companion object{
        val TAG:String= HobbiesAdapter::class.java.simpleName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesAdapter.ViewHolder {
        val view  =LayoutInflater.from(context).inflate(R.layout.list_hobbies,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HobbiesAdapter.ViewHolder, position: Int) {
        val hobbies = hobbyist[position]
        holder.setData(hobbies,position)

    }

    override fun getItemCount(): Int {
            return hobbyist.size

    }

    inner  class ViewHolder(interview: View): RecyclerView.ViewHolder(interview) {

        private val textview = interview.findViewById<TextView>(R.id.title_tv)
        private val share = interview.findViewById<ImageView>(R.id.image_iv)

        private var currentHobby:Hobby?=null
        private var currentPosition:Int=0

        init {
            textview.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title +"is clicked on position"+currentPosition) }
            }

            share.setOnClickListener {
                val intent = Intent()
                intent.action=Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, currentHobby?.title)
                context.startActivity(Intent.createChooser(intent,"Share Hobby"))
            }

        }

        fun  setData(hobby: Hobby?, position: Int){
            hobby?.let {
                textview.text = hobby.title
                this.currentHobby=hobby
                this.currentPosition=position
            }

        }
    }

}