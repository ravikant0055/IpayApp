package com.example.ipay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_pair.*

class PairActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pair)

        aboutbtn.setOnClickListener {
            startActivity(Intent(this@PairActivity,AboutActivity::class.java))

        }
        bbfimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }
        vimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }
        easyimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }
        globusimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }
        lifeimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }

        maximg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }
        ssimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }
        trendsimg.setOnClickListener {
            startActivity(Intent(this@PairActivity,ScanActivity::class.java))

        }

    }




}