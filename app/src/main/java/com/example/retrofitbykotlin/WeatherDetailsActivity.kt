package com.example.retrofitbykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_weather_details_activity.*
import kotlinx.android.synthetic.main.activity_weather_details_activity.view.*

class WeatherDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details_activity)
        setSupportActionBar(toolbar)
    }
}
