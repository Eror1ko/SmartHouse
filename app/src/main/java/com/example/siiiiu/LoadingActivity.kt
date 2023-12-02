package com.example.siiiiu

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loadingpicture)

        val timer = object : CountDownTimer(2000,1000)
        {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent( this@LoadingActivity,MainActivity::class.java)
                startActivity(intent)

            }
        }
        timer.start()


    }
}