package com.muflidevs.programmingL.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.muflidevs.programmingL.Data.ProgrammingData
import com.muflidevs.programmingL.DetailActivity
import com.muflidevs.programmingL.R


class ListProgrammingAdapter(private val listProgramming : ArrayList<ProgrammingData>)
    : RecyclerView.Adapter<ListProgrammingAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_programming,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listProgramming.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(judul,description,photo) = listProgramming[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvJudul.text = judul
        holder.tvDesc.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_bahasa",listProgramming[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_view)
        val tvJudul : TextView = itemView.findViewById(R.id.tv_title)
        val tvDesc : TextView = itemView.findViewById(R.id.tv_desc)

    }

}