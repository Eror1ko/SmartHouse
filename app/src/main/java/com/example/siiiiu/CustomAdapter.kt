package com.example.siiiiu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(private val context: Activity, private val title: ArrayList<DataClass.Test>): ArrayAdapter<DataClass.Test>(context,R.layout.custom_list,title) {

    class CustomAdapter(
        private val names: ArrayList<DataClass.Test>
    ) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textCustom: TextView = itemView.findViewById(R.id.textcustom)
            val imageCustom: ImageView = itemView.findViewById(R.id.imagecustom)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_list, parent, false)
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return names.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            holder.textCustom.text = names[position].toString()
            holder.imageCustom.setImageDrawable(array[position])
        }


        val array= arrayOf(R.drawable.living_blue11,R.drawable.bathroom_blue11,R.drawable.kitchen_blue11,R.drawable.office_blue11,R.drawable.bed_gray1,R.drawable.tv_blue11,) ;

    }
}