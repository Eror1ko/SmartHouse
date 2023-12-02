package com.example.siiiiu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class PinCodeCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_code_create)

        /*
        val sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
        val pressedButtons = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        val pinCodeBuilder = StringBuilder()

        pressedButtons.forEach{button -> pinCodeBuilder.append(button)}

        val editor = sharedPreferences.edit()
        editor.putString("pinCode", pinCodeBuilder.toString())
        editor.apply()


        val savedPinCode = sharedPreferences.getString("pinCode", "")

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("pinCode", savedPinCode)
        startActivity(intent)
        finish()
        */
    }
}