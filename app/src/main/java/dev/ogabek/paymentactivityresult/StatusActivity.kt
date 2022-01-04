package dev.ogabek.paymentactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        initViews()

    }

    private fun initViews() {
        val success = findViewById<Button>(R.id.btn_succes)
        success.setOnClickListener {
            openMainActivity()
        }
        val failure = findViewById<Button>(R.id.btn_failure)
        failure.setOnClickListener {
            openConfirmActivity()
        }
    }

    private fun openMainActivity() {
        val intent = Intent()
        intent.putExtra("result", "success")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun openConfirmActivity() {
        val intent = Intent()
        intent.putExtra("result", "fail")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}