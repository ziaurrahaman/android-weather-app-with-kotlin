package com.example.retrofitbykotlin

import com.example.retrofitbykotlin.model.WeatherDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getWeatherForCity(@Query("q") city: String, @Query("appid") appid: String = "e72ca729af228beabd5d20e3b7749713"): Call<WeatherDataModel>

}