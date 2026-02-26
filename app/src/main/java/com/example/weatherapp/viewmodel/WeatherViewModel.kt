package com.example.weatherapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.WeatherAPI
import com.example.weatherapp.model.WeatherDataClass
import com.example.weatherapp.repository.WeatherRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    private val _weatherData = MutableStateFlow<WeatherDataClass?>(null)   // creating a private, changeable data stream that will hold weather data — and it starts empty. MutableStateFlow<> -> Data can change. We used private so that it can only be changed by ViewModel, not by UI.
    val weatherData: StateFlow<WeatherDataClass?> = _weatherData      //  UI can observe the weather, but it cannot change it. StateFlow<> -> Read only

    fun fetchWeatherByLocation(lat: Double, lon: Double) {
        viewModelScope.launch {
            val result = repository.getWeather(lat, lon)
            _weatherData.value = result
        }
    }

    fun getSavedLocation(): Pair<Double, Double>? {
        return repository.getSavedLocation()
    }
}