package com.example.whac_a_mole

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    private fun saveText(record:String) {
//        val sPref = getSharedPreferences("MyPref", MODE_PRIVATE)
//        val ed: SharedPreferences.Editor = sPref.edit()
//        ed.putString("Saved text", record)
//        ed.commit()
//        //Toast.makeText(this@MainActivity, "Text saved", Toast.LENGTH_SHORT).show()
//    }
//
//    fun loadText(): String? {
//        val sPref = getSharedPreferences("MyPref", MODE_PRIVATE)
//        return sPref.getString("Saved text", "")
//        //Toast.makeText(this@MainActivity, "Text loaded", Toast.LENGTH_SHORT).show()
//    }

}