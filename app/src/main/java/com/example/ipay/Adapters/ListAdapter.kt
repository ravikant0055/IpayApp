package com.example.ipay.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.ipay.ListModel
import com.example.ipay.OnClickLIstener
import com.example.ipay.R
import kotlinx.android.synthetic.main.activity_list.view.*
import kotlinx.android.synthetic.main.additem.view.*

class ListAdapter(val arrayList: ArrayList<ListModel>,val context: Context,val onClickLIstener: OnClickLIstener)
    :RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var btn_pay : Button = itemView.paybtn
        fun bindItems(model: ListModel){
        itemView.itemidd.text=model.itemid
        itemView.descrip.text=model.description
        itemView.pricess.text=model.price
        itemView.deletebtnnn.setImageResource(model.deletebtn)
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.additem,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.btn_pay.setOnClickListener {
            onClickLIstener.onItemClick(arrayList[position])
        }
    }
    
}
