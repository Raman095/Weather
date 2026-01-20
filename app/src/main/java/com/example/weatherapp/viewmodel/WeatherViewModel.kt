package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.WeatherAPI
import com.example.weatherapp.model.WeatherDataClass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val _weatherData = MutableStateFlow<WeatherDataClass?>(null)   // creating a private, changeable data stream that will hold weather data — and it starts empty. MutableStateFlow<> -> Data can change. We used private so that it can only be changed by ViewModel, not by UI.
    val weatherData: StateFlow<WeatherDataClass?> = _weatherData      //  UI can observe the weather, but it cannot change it. StateFlow<> -> Read only
    private val weatherApi = WeatherAPI.create()    // private used because -> Only the ViewModel is allowed to use the API implementation, that we did in WeatherAPI.kt

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather(city, apiKey)
                _weatherData.value = response     // storing in _weatherData, then it will be stored in weatherData variable created above, then we will use that weatherData variable in UI.
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}