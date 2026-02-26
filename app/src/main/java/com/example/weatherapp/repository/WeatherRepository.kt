package com.example.weatherapp.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.weatherapp.model.WeatherAPI
import com.example.weatherapp.model.WeatherDataClass
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(@param: ApplicationContext private val context: Context) {

    private val api = WeatherAPI.create()  // private used because -> Only the ViewModel is allowed to use the API implementation, that we did in WeatherAPI.kt
    private val sharedPref =
        context.getSharedPreferences("weather_prefs", Context.MODE_PRIVATE)

    private val apikey = "f3ad2a055051d0f4bb3515011e7b06ab"

    suspend fun getWeather(lat: Double, lon: Double): WeatherDataClass? {

        return if (isInternetAvailable(context)) {
            try {
                val response = api.getWeather(lat, lon, apikey)
                saveWeatherToCache(response)
                saveLocation(lat, lon)
                response
            } catch (e: Exception) {
                loadCachedWeather()
            }
        } else {
            loadCachedWeather()
        }
    }

    private fun saveWeatherToCache(data: WeatherDataClass) {
        val json = Gson().toJson(data)
        sharedPref.edit().putString("last_weather", json).apply()
    }

    private fun loadCachedWeather(): WeatherDataClass? {
        val json = sharedPref.getString("last_weather", null)
        return json?.let {
            Gson().fromJson(it, WeatherDataClass::class.java)
        }
    }

    private fun saveLocation(lat: Double, lon: Double) {
        sharedPref.edit()
            .putFloat("lat", lat.toFloat())
            .putFloat("lon", lon.toFloat())
            .apply()
    }

    fun getSavedLocation(): Pair<Double, Double>? {
        val lat = sharedPref.getFloat("lat", 0f)
        val lon = sharedPref.getFloat("lon", 0f)

        return if (lat != 0f && lon != 0f) {
            Pair(lat.toDouble(), lon.toDouble())
        }
        else null
    }

    private fun isInternetAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                 as ConnectivityManager

        val network = cm.activeNetwork ?: return false
        val capabilities = cm.getNetworkCapabilities(network) ?: return false

        return capabilities.hasCapability(
            NetworkCapabilities.NET_CAPABILITY_INTERNET
        )
    }

}