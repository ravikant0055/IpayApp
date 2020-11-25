package com.example.ipay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_list.*

import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class ListActivity : AppCompatActivity(),OnClickLIstener,PaymentResultListener {

    lateinit var btnadd: Button
     companion object{
         var arrayList=ArrayList<ListModel>()
         var total:Int=0
     }
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

        arrayList.add(ListModel("1", thing as String, price as String,R.drawable.delete))
        val myAdapter=ListAdapter(arrayList, applicationContext,this)
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.adapter=myAdapter
        totalView.setText((total+price.toInt()).toString())

        btnadd.setOnClickListener {
            startActivity(Intent(this,ScanActivity::class.java))
        }

    }


    // Gateway code.......................................

    override fun onItemClick(model: ListModel) {
       startPayment(model)
    }

    private fun startPayment(model: ListModel){
        var checkout = Checkout()
        try {
            val options = JSONObject()
            options.put("name", model.description)
            options.put("description", "Reference No. #123456")
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("amount", totalView.toString().toDouble()*100) //pass amount in currency subunits
            options.put("prefill.email", "example.@example.com")
            options.put("prefill.contact", "9988776655")
            checkout.open(this, options)
        } catch (e: Exception) {
            Toast.makeText(applicationContext,"Payment failed",Toast.LENGTH_LONG).show()
        }
    }
    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(applicationContext,"Payment failed", Toast.LENGTH_LONG).show()
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(applicationContext,"Payment Success",Toast.LENGTH_LONG).show()
    }


}