package com.example.siiiiu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class CreatePinCode : AppCompatActivity() {
    var password: String = ""
    lateinit var ell1 : ImageView
    lateinit var ell2 : ImageView
    lateinit var ell3 : ImageView
    lateinit var ell4 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pin_code)
        ell1 = findViewById(R.id.ell1)
        ell2 = findViewById(R.id.ell2)
        ell3 = findViewById(R.id.ell3)
        ell4 = findViewById(R.id.ell4)
    }


    fun click1(view : View)
    {
        val test: Button = view as Button
        password += test.text
        Log.e("!", password.toString())
        if(password.length == 1)
        {
            ell1.background = (getDrawable(R.drawable.whiteellipse))
            ell2.background = (getDrawable(R.drawable.grayellipse))
            ell3.background = (getDrawable(R.drawable.grayellipse))
            ell4.background = (getDrawable(R.drawable.grayellipse))
        }
        if(password.length == 2)
        {
            ell1.background = (getDrawable(R.drawable.whiteellipse))
            ell2.background = (getDrawable(R.drawable.whiteellipse))
            ell3.background = (getDrawable(R.drawable.grayellipse))
            ell4.background = (getDrawable(R.drawable.grayellipse))
        }
        if(password.length == 3)
        {
            ell1.background = (getDrawable(R.drawable.whiteellipse))
            ell2.background = (getDrawable(R.drawable.whiteellipse))
            ell3.background = (getDrawable(R.drawable.whiteellipse))
            ell4.background = (getDrawable(R.drawable.grayellipse))
        }
        if(password.length == 4)
        {
            ell1.background = (getDrawable(R.drawable.whiteellipse))
            ell2.background = (getDrawable(R.drawable.whiteellipse))
            ell3.background = (getDrawable(R.drawable.whiteellipse))
            ell4.background = (getDrawable(R.drawable.whiteellipse))

            val Intentik = Intent(this, add_adress_layout::class.java)
            startActivity(Intentik)
        }
    }
}