package com.example.ipay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PairActivity : AppCompatActivity() {
    lateinit var aboutbtn:ImageView
    lateinit var bbfimage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pair)
        aboutbtn=findViewById(R.id.aboutbtn)
        bbfimage=findViewById(R.id.bbfimg)
        aboutbtn.setOnClickListener {
            startActivity(Intent(this@PairActivity,AboutActivity::class.java))
            finish()
        }
        bbfimage.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))
            finish()
        }
    }




}