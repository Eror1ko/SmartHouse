package com.example.siiiiu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class add_adress_layout : AppCompatActivity() {
    data class AdressAdd (val Adress : String = "")
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
        setContentView(R.layout.add_adress_layout)
        val addAdress = findViewById<EditText>(R.id.editinfo)
        val btnSave = findViewById<EditText>(R.id.btnSave)


        btnSave.setOnClickListener {
            val city = AdressAdd(Adress = addAdress.text.toString())
            lifecycleScope.launch {

            }
            lifecycleScope.launch {
                client.postgrest["Data"].insert(city)
            }
            val intenttt = Intent(this, AddRoom::class.java)
            startActivity(intenttt)
        }


    }
}