package com.example.ipay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.additem.view.*

class ListAdapter(
    val arrayList:ArrayList<ListModel>,
    val context: ListActivity
):
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(model: ListModel){
            itemView.itemid.text=model.itemid
            itemView.description.text=model.description
            itemView.price.text=model.price
            itemView.deletebtn.setImageResource(model.deletebtn)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.additem,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])


    }
}