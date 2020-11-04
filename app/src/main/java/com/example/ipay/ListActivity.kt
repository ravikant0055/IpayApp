package com.example.ipay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_list.*

import android.widget.Button
import android.widget.TextView

class ListActivity : AppCompatActivity() {
    lateinit var btnadd: Button
    lateinit var textView11:TextView
    lateinit var textView12:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnadd=findViewById(R.id.btnadd)
        textView11=findViewById(R.id.textView11)
        textView12=findViewById(R.id.textView12)
        val bundle: Bundle? = intent.extras
        val price = bundle?.get("name")
        val thing = bundle?.get("thing")
        textView11.text= thing as CharSequence?
        textView12.text= price as CharSequence?

        btnadd.setOnClickListener {
            startActivity(Intent(this,ScanActivity::class.java))
        }

    }

}