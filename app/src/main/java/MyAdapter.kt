package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val namaList: ArrayList<ItemData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder (itemData: View) : RecyclerView.ViewHolder (itemData) {
        val img :ImageView = itemData.findViewById(R.id.imageView5)
        val nama : TextView = itemData.findViewById(R.id.textView6)
        val desc : TextView = itemData.findViewById(R.id.textView7)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = namaList[position]
        holder.nama.text = item.nama
        holder.desc.text = item.desc
        holder.img.setImageResource(item.img)
    }

}
