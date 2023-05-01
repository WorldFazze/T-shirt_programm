package com.bignerdranch.android.t_shirt_programm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FootballShirtAdapter(private val footballShirtList: List<TShirt>, private val listener: OnItemClickListener) : RecyclerView.Adapter<FootballShirtAdapter.FootballShirtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballShirtViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_futbolka, parent, false)
        return FootballShirtViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FootballShirtViewHolder, position: Int) {
        val currentItem = footballShirtList[position]
        holder.textViewName.text = currentItem.name
        holder.textViewPrice.text = currentItem.price.toString()
        holder.textViewMaterial.text = currentItem.material
        holder.textViewSize.text = currentItem.size
        holder.textViewColor.text = currentItem.color
//        holder.imageView.setImageResource(currentItem.imageView)
    }

    override fun getItemCount() = footballShirtList.size

    inner class FootballShirtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewName: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewPrice: TextView = itemView.findViewById(R.id.FootballShirtPrice)
        val textViewMaterial: TextView = itemView.findViewById(R.id.FootballShirtMaterial)
        val textViewSize: TextView = itemView.findViewById(R.id.FootballShirtSize)
        val textViewColor: TextView = itemView.findViewById(R.id.FootballShirtColor)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
