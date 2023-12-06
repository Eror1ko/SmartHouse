package com.example.siiiiu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(val room: ArrayList<DataClass.Room>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val roomImageBut: ImageButton = itemView.findViewById(R.id.imagefurniture)
        val roomNameText: TextView = itemView.findViewById(R.id.textfurniture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val listView = LayoutInflater.from(parent.context).inflate(R.layout.custom_furniture, parent, false)
        return MyViewHolder(listView)
    }

    override fun getItemCount(): Int {
        return room.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rooms = room[position]
        //val drawable = getDrawableFromString(rooms.Иконка)
        holder.roomImageBut.setImageResource(room[position].Image)
        holder.roomNameText.text = room[position].RoomName
    }

    /*private fun getDrawableFromString(иконка: String): Drawable? {
        val res = context.resources.getIdentifier(иконка, "drawable", context.packageName)
        return ContextCompat.getDrawable(context, res)
    }*/

}


      //  val array= arrayOf(R.drawable.living_blue11,R.drawable.bathroom_blue11,R.drawable.kitchen_blue11,R.drawable.office_blue11,R.drawable.bed_gray1,R.drawable.tv_blue11,) ;


