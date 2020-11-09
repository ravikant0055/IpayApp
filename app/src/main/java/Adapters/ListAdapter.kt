package Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipay.Listmodel
import com.example.ipay.R

class ListAdapter(var list: ArrayList<Listmodel>,var  context: Context) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.additem,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}