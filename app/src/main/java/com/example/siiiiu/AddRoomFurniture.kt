package com.example.siiiiu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException

class AddRoomFurniture : AppCompatActivity() {
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
        setContentView(R.layout.activity_add_room_furniture)
        val viewItems = ArrayList<DataClass.Room>()
//        viewItems.add(DataClass.Room(0,R.drawable.whiteellipse,"sjdfjsdf"))
//        viewItems.add(DataClass.Room(0,R.drawable.whiteellipse,"sjdfjsdf"))
//        viewItems.add(DataClass.Room(0,R.drawable.whiteellipse,"sjdfjsdf"))
//        viewItems.add(DataClass.Room(0,R.drawable.whiteellipse,"sjdfjsdf"))

        lifecycleScope.launch {
            val city = client().postgrest["Rooms"].select()
            val buf = StringBuilder()
            buf.append(city.body.toString()).append("\n")
            var array: JSONArray = JSONArray(buf.toString())

            try{
                for (i in 0 until  array.length()){
                    val item = array.getJSONObject(i)
                    val id: Int = item.getInt("id")
                    val Image: Int = item.getInt("Picture")
                    val RoomName: String = item.getString("Name")
                    val room = DataClass.Room(id, Image , RoomName)
                    viewItems.add(room)
                }
            } catch (e: JSONException){
                Log.e("!!!", e.message.toString())
            }
        }

        val mListView: RecyclerView = findViewById(R.id.recyclerfurniture)
        mListView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        mListView.adapter = CustomAdapter(viewItems)

    }
}