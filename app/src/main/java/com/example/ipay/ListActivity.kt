package com.example.ipay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_list.*

import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    lateinit var btnadd: Button
    lateinit var textView11:TextView
    lateinit var textView12:TextView
    lateinit var itemlistview:RecyclerView
    private val arraylist=ArrayList<Listmodel>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnadd=findViewById(R.id.btnadd)
//        textView11=findViewById(R.id.textView11)
//        textView12=findViewById(R.id.textView12)
        val bundle: Bundle? = intent.extras
        val price = bundle?.get("name")
        val thing = bundle?.get("thing")
//        textView11.text= thing as CharSequence?
//        textView12.text= price as CharSequence?
        //itemlistview=findViewById(R.id.itemlistview)
        arraylist.add(Listmodel("1", thing as String, price as String,R.drawable.delete))
        arraylist.add(Listmodel("1", thing , price,R.drawable.delete))

        val listadapter=ListAdapter(arraylist,this)
        itemlistview.layoutManager = LinearLayoutManager(this)
        itemlistview.adapter=listadapter

        btnadd.setOnClickListener {
            startActivity(Intent(this,ScanActivity::class.java))
        }

    }

}