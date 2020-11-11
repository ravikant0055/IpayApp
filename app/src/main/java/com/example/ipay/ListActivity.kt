package com.example.ipay

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_list.*

import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.additem.*

class ListActivity : AppCompatActivity() {

    lateinit var btnadd: Button
//    lateinit var textView11:TextView
//    lateinit var textView12:TextView


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnadd=findViewById(R.id.btnadd)
//        textView11=findViewById(R.id.description)
//        textView12=findViewById(R.id.price)
        val bundle: Bundle? = intent.extras
        val price = bundle?.get("name")
        val thing = bundle?.get("thing")
//        textView11.text= thing as CharSequence?
//        textView12.text= price as CharSequence?
        val arrayList=ArrayList<ListModel>()
        arrayList.add(ListModel("1", thing as String, price as String,R.drawable.delete))
        //arrayList.add(ListModel("1", thing , price,R.drawable.delete))
        val myAdapter=ListAdapter(arrayList,this)
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.adapter=myAdapter

        btnadd.setOnClickListener {
            startActivity(Intent(this,ScanActivity::class.java))
        }

    }

}