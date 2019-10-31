package com.example.retrofitbykotlin.model

import com.google.gson.annotations.SerializedName

data class WeatherDataModel (var clouds: Clouds, var coord: Coord, var json4kotlinBase: Json4Kotlin_Base, var main: Main, var weather: List<Weather>, var wind: Wind, var sys: Sys){

    data class Wind (

        @SerializedName("speed") val speed : Double,

        @SerializedName("deg") val deg : Double,

        @SerializedName("gust") val gust : Double
    )

    data class Coord (

        @SerializedName("lon") val lon : Double,

        @SerializedName("lat") val lat : Double
    )

    data class Json4Kotlin_Base (

        @SerializedName("coord") val coord : Coord,

        @SerializedName("weather") val weather : List<Weather>,

        @SerializedName("base") val base : String,

        @SerializedName("main") val main : Main,

        @SerializedName("wind") val wind : Wind,


        @SerializedName("clouds") val clouds : Clouds,

        @SerializedName("dt") val dt : Double,

        @SerializedName("sys") val sys : Sys,

        @SerializedName("timezone") val timezone : Double,

        @SerializedName("id") val id : Double,

        @SerializedName("name") val name : String,

        @SerializedName("cod") val cod : Double
    )

    data class Main (

        @SerializedName("temp") val temp : Double,

        @SerializedName("pressure") val pressure : Double,

        @SerializedName("humidity") val humidity : Double,

        @SerializedName("temp_min") val temp_min : Double,

        @SerializedName("temp_max") val temp_max : Double
    )




    data class Sys (

        @SerializedName("type") val type : Double,

        @SerializedName("id") val id : Double,

        @SerializedName("country") var country : String,

        @SerializedName("sunrise") val sunrise : Double,

        @SerializedName("sunset") var sunset : Double
    )

    data class Weather (

        @SerializedName("id") val id : Double,

        @SerializedName("main") val main : String,

        @SerializedName("description") val description : String,

        @SerializedName("icon") val icon : String
    )

    data class Clouds (

        @SerializedName("all") val all : Double
    )
}


