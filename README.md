<h1 align="center">🌤 WeatherNow – Location Based Weather App</h1>

<p align="center">
  <b>Modern Android Weather Application built with Jetpack Compose</b>
</p>

---

## 📌 Introduction

WeatherNow is a location-based Android weather application that automatically fetches and displays real-time weather data based on the user's current location.

When the user opens the app:

- The app requests location permission
- Once granted, a loading indicator is shown
- Weather data is fetched using an API
- The current weather details are displayed in structured cards

The application demonstrates runtime permission handling, API integration, clean UI design, and modern Android architecture practices.

---

## ✨ Features

- 📍 Runtime Location Permission Handling
- 🔄 Automatic Weather Fetch Based on User Location
- ⏳ Loading Indicator while fetching data
- 🌡 Displays Current Temperature
- 💧 Displays Humidity
- 🏙 Displays City Name
- 🌥 Displays Weather Description (Haze, Clear, Clouds, etc.)
- 🎨 Built using Material 3 Design
- 🧠 Structured using MVVM Architecture

---

## 📸 Screenshots

<p align="center">
  <img src="images/WhatsApp Image 2026-02-26 at 4.49.25 PM.jpeg" width="240"/>
  <img src="images/WhatsApp Video 2026-02-26 at 4.49.24 PM.gif" width="240"/>
</p>

---

## 🏗 Architecture

The application follows MVVM (Model – View – ViewModel) architecture:

- Model → API response data classes
- View → Jetpack Compose UI
- ViewModel → Handles business logic and state management
- Repository → Manages network calls using Retrofit

This ensures separation of concerns, maintainability, and scalability.

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- Retrofit (API Integration)
- Location Services
- Runtime Permission Handling
- MVVM Architecture

---

## 🚀 App Flow

1. User opens the app
2. Location permission is requested
3. After permission is granted:
   - Current location is retrieved
   - Weather API is called
   - Loading indicator is displayed
4. Weather information is shown in UI cards

---

## 📦 Future Improvements

- Search Weather by City Name
- Dark Mode Support
- Improved UI Animations
- Error Handling Enhancements
