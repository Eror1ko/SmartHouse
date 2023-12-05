package com.example.siiiiu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import org.json.JSONArray

class AddRoom : AppCompatActivity() {
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
        setContentView(R.layout.add_room)
        val btnAdd = findViewById<ImageButton>(R.id.btnAddRoom)
        val arrayT: ArrayList<DataClass.Test> = ArrayList()
        Log.e("!!", "2")


        btnAdd.setOnClickListener {
            lifecycleScope.launch {

                val city = client.postgrest["Rooms"].select()
                val array: JSONArray = JSONArray(city.body.toString())


                for (i in 0 until array.length()) {//step 1
                    Log.e("!!", "2")
                    val itemObj = array.getJSONObject(i)
                    val id = itemObj.getInt("id")
                    val TextRoom = itemObj.getString("Name")
                    val pars = DataClass.Test(TextRoom = "", Image =)
                    arrayT.add(pars);

                }
            }
        }

    }
}