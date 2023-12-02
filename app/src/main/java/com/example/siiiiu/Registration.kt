package com.example.siiiiu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class Registration : AppCompatActivity() {
    @kotlinx.serialization.Serializable
    data class UserData(val Login: String = "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val editEmail = findViewById<EditText>(R.id.editMail)
        val editLogin = findViewById<EditText>(R.id.editLogin)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val btnSend = findViewById<Button>(R.id.btnRegistration)
        val btnIn = findViewById<Button>(R.id.btnIn)


        val client = createSupabaseClient(
            supabaseUrl = "https://glwyfmrukvbrductrilt.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imdsd3lmbXJ1a3ZicmR1Y3RyaWx0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEyNDU4NzUsImV4cCI6MjAxNjgyMTg3NX0.LlIi3cEdaFEbKfWAqgRvC6KepfDJLhreARfX6Rw-ubI"
        ) {
            install(GoTrue)
            install(Postgrest)
            //install other modules
        }

        btnSend.setOnClickListener {
            val city = UserData(Login = editLogin.text.toString())
            lifecycleScope.launch {
                val user = client.gotrue.signUpWith(Email) {
                    email = editEmail.text.toString()
                    password = editPassword.text.toString()
                }
            }
            lifecycleScope.launch {
                client.postgrest["Data"].insert(city)
            }
        }

        fun btnIn(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}