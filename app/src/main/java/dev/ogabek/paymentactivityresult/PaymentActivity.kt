package dev.ogabek.paymentactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        initViews()

    }

    private fun initViews() {
        val pay = findViewById<Button>(R.id.btn_pay)
        pay.setOnClickListener {
            openConfirmActivity()
        }
    }

    private fun openConfirmActivity() {
        val intent = Intent(this, ConfirmActivity::class.java)
        resultActivity.launch(intent)
    }

    private var resultActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val result = data!!.getStringExtra("result")
            if (result.toString() == "success") {
                finish()
            } else if (result.toString() == "fail") {
                Toast.makeText(this, "Fail in Payment Activity", Toast.LENGTH_SHORT).show()
            }
        }
    }

}