package com.example.siiiiu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity(){
    private val loadingTime : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loadingpicture)
        simulateLoading()
        finish()
    }

    private fun simulateLoading(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }, loadingTime)
    }


}