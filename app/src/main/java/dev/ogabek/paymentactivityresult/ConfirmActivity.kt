package dev.ogabek.paymentactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        initViews()

    }

    private fun initViews() {
        val confirm = findViewById<Button>(R.id.btn_confirm)
        confirm.setOnClickListener {
            openStatusActivity()
        }
    }

    private fun openStatusActivity() {
        val intent = Intent(this, StatusActivity::class.java)
        resultActivity.launch(intent)
    }

    var resultActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val result = data!!.getStringExtra("result")
            if (result.toString() == "success") {
                val intent = Intent()
                intent.putExtra("result", result.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (result.toString() == "fail") {
                Toast.makeText(this, "Fail in confirm Activity", Toast.LENGTH_SHORT).show()
            }
        }
    }

}