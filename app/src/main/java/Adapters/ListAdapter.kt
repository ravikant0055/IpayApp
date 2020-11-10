package Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipay.ListActivity
import com.example.ipay.Listmodel
import com.example.ipay.R
import kotlinx.android.synthetic.main.additem.view.*

class ListAdapter(val arraylist: ArrayList<Listmodel>, var context: Context)
    :RecyclerView.Adapter<ListAdapter.ViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
//       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.additem,parent,false))
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
//
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//    }
//
//}

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(model: Listmodel){
            itemView.itemid.text=model.itemid
            itemView.description.text=model.description
            itemView.price.text=model.price
            itemView.deletebtn.setImageResource(model.deletebtn)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.additem,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arraylist[position])
    }

}