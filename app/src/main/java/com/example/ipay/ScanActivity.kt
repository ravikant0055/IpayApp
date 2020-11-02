package com.example.ipay

import android.app.Activity
import android.app.Activity.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class ScanActivity : AppCompatActivity() {
    lateinit var scanbtn:Button
    lateinit var aboutbtn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        scanbtn=findViewById(R.id.scanbtn)
        scanbtn.setOnClickListener {
            val scanner=IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES)
            scanner.setBeepEnabled(false)
            scanner.setPrompt("Scan a barcode")
            scanner.setBarcodeImageEnabled(true)
            scanner.initiateScan()
        }
        aboutbtn=findViewById(R.id.aboutbtn)
        aboutbtn.setOnClickListener {
            startActivity(Intent(this@ScanActivity,AboutActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode==Activity.RESULT_OK)
        {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null) {
                if(result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}