package com.example.retrofitbykotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enter_city_name_et.setOnClickListener { it as EditText
            val cityName = it.text
            val intent = Intent(this@MainActivity, WeatherDetailsActivity2::class.java)
            intent.putExtra("city_name", cityName.toString())
            startActivity(intent)
        }


    }



}
