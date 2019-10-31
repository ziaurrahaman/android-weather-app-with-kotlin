package com.example.retrofitbykotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofitbykotlin.model.WeatherDataModel
import kotlinx.android.synthetic.main.activity_weather_details3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherDetailsActivity2 : AppCompatActivity() {

    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details3)

        val cityName = intent.getStringExtra("city_name")
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)
        val call = weatherService.getWeatherForCity(cityName)

        call.enqueue(object : Callback<WeatherDataModel>{
            override fun onFailure(call: Call<WeatherDataModel>, t: Throwable) {
                Log.d("ResponseError", t.message)
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<WeatherDataModel>,
                response: Response<WeatherDataModel>
            ) {
                Log.d("Response", response.toString())
                val cityWeather: WeatherDataModel? = response.body() ?: return


                val tempInDegreeCelsius = cityWeather!!.main.temp - 273
                weather_details_layout2_temperature_header.text = String.format("%.2f",tempInDegreeCelsius)+"°C".toString()
                city_latitude.text = cityWeather.coord.lat.toString()
                city_longitude.text = cityWeather.coord.lon.toString()
                weather_condition.text = cityWeather.weather[0].main
                details_weather_condition.text = cityWeather.weather[0].description
                val minTempInDegreeCelsius = cityWeather.main.temp_min - 273
                minimum_temperature.text = String.format("%.2f",minTempInDegreeCelsius)+"°C"
                val maxTempInDegreeCelsius = cityWeather.main.temp_max - 273

                maximum_temperature.text = String.format("%.2f",maxTempInDegreeCelsius)+"°C"
                humidity.text = cityWeather.main.humidity.toString()+"%"
                wind_speed.text = cityWeather.wind.speed.toString()

                val resourceId =
                    resources.getIdentifier(updateWeatherIcon(cityWeather.weather[0].id.toInt()), "drawable", packageName)
                weather_details_activity3_imageView.setImageResource(resourceId)
            }
        })




    }
    private fun updateWeatherIcon(condition: Int): String {

        if (condition in 0..300) {
            return "tstorm1"
        } else if (condition in 300..500) {
            return "light_rain"
        } else if (condition in 500..600) {
            return "shower3"
        } else if (condition in 600..700) {
            return "snow4"
        } else if (condition in 700..771) {
            return "fog"
        } else if (condition in 772..800) {
            return "tstorm3"
        } else if (condition == 800) {
            return "sunny"
        } else if (condition in 801..804) {
            return "cloudy2"
        } else if (condition in 900..902) {
            return "tstorm3"
        } else if (condition == 903) {
            return "snow5"
        } else if (condition == 904) {
            return "sunny"
        } else if (condition in 905..1000) {
            return "tstorm3"
        }

        return "dunno"
    }

}
