package com.example.siiiiu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import org.json.JSONArray

class MainActivity : AppCompatActivity() {



    public val client = createSupabaseClient(
        supabaseUrl = "https://glwyfmrukvbrductrilt.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imdsd3lmbXJ1a3ZicmR1Y3RyaWx0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEyNDU4NzUsImV4cCI6MjAxNjgyMTg3NX0.LlIi3cEdaFEbKfWAqgRvC6KepfDJLhreARfX6Rw-ubI"
    ) {
        install(GoTrue)
        install(Postgrest)
        //install other modules
    }
    fun client() : SupabaseClient
    {
        return client
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnReg = findViewById<Button>(R.id.btnReg)
        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val emailAuth = findViewById<EditText>(R.id.emailAuth)
        val passAuth = findViewById<EditText>(R.id.passwordAuth)

        val arrayT: ArrayList<DataClass.Test> = ArrayList()
        Log.e("!!", "2")


        /* ПОЛУЧЕНИЕ И ПРОВЕРКА ПИН-КОДА
        val receivedPinCode = intent.getStringExtra("pinCode")

        if(receivedPinCode.isNullOrEmpty()){
            startActivity(Intent(this, PinCodeCreate::class.java))
        }
        else{
            startActivity(Intent(this, PinCodeCreate::class.java))
        }
        */

        btnReg.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        btnEnter.setOnClickListener {
            lifecycleScope.launch {
               client().gotrue.loginWith(Email) {
                    email = emailAuth.text.toString()
                    password = passAuth.text.toString()
                }
            }
            val intent = Intent(this, PinCodePress::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch {

            val city = client.postgrest["Rooms"].select()
            val array: JSONArray = JSONArray(city.body.toString())

            for (i in 0 until array.length()) {//step 1
                Log.e("!!", "2")
                val itemObj = array.getJSONObject(i)
                val id = itemObj.getInt("id")
                val name = itemObj.getString("name")
                val pars = DataClass.Test(TextRoom = "", Image =)
                arrayT.add(pars);

            }
        }


    }
}