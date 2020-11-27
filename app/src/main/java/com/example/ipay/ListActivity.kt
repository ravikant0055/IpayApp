package com.example.ipay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_list.*

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.razorpay.Checkout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity(),PaymentResultWithDataListener{

    lateinit var btnadd: Button
    lateinit var retrofit: Retrofit
    lateinit var retroInterface: RetrofitInterface

     companion object{var arrayList=ArrayList<ListModel>()
     var total:Int=0
     }
//    lateinit var textView11:TextView
//    lateinit var textView12:TextView



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btnadd=findViewById(R.id.btnadd)

//      textView11=findViewById(R.id.description)
//      textView12=findViewById(R.id.price)
        val bundle: Bundle? = intent.extras
        val price = bundle?.get("name")
        val thing = bundle?.get("thing")
//        textView11.text= thing as CharSequence?
//        textView12.text= price as CharSequence?

        arrayList.add(ListModel("1", thing as String, price as String,R.drawable.delete))
        val myAdapter=ListAdapter(arrayList, this)
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.adapter=myAdapter
        total=total+price.toInt()
        totalView.setText((total.toInt()).toString())

        btnadd.setOnClickListener {
            startActivity(Intent(this,ScanActivity::class.java))
        }

        // Gateway code.......................................
        Checkout.preload(applicationContext)

        val gson = GsonBuilder().setLenient()

        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.43.13:3000")
            .addConverterFactory(GsonConverterFactory.create(gson.create()))
            .build()

        retroInterface = retrofit.create(RetrofitInterface::class.java)


        findViewById<Button>(R.id.paybtn)
            .setOnClickListener {

                val amountEdit: TextView = findViewById(R.id.totalView);
                val amount = amountEdit.text.toString()

                if (amount.isEmpty()) {
                    return@setOnClickListener
                }

                getOrderId(amount)

            }

    }

    // Gateway code.......................................

    private fun getOrderId(amount: String) {
        val map = HashMap<String, String>()
        map["amount"] = amount

        retroInterface
            .getOrderId(map).enqueue(object : Callback<Order> {
                override fun onFailure(call: Call<Order>, t: Throwable) {
                    Toast.makeText(this@ListActivity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Order>, response: Response<Order>) {
                    if (response.body() != null)
                        initiatePayment(amount, response.body()!!)
                }

            })
    }

    private fun initiatePayment(amount: String, order: Order) {

        val checkout = Checkout()
        checkout.setKeyID(order.getKeyId())

        checkout.setImage(R.drawable.ic_launcher_background)

        val paymentOptions = JSONObject()
        paymentOptions.put("name", "Ipay")
        paymentOptions.put("amount", amount)
        paymentOptions.put("order_id", order.getOrderId())
        paymentOptions.put("currency", "INR")
        paymentOptions.put("description", "Reference no: #1234")
        checkout.open(this, paymentOptions)
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Toast.makeText(this, "Payment failed", Toast.LENGTH_LONG).show()
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        val map = HashMap<String, String>()

        map["order_id"] = p1!!.orderId
        map["pay_id"] = p1.paymentId
        map["signature"] = p1.signature

        retroInterface.updateTransaction(map)
            .enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@ListActivity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {

                    if (response.body().equals("success"))
                        Toast.makeText(this@ListActivity, "Payment successful", Toast.LENGTH_LONG).show()
                }

            })
    }


}