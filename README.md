# 🌤️ Weather App (Jetpack Compose)

## 📌 Introduction

This is a modern Android Weather Application built using **Jetpack Compose** and **Retrofit** for API integration.

The app allows users to enter the name of a city and fetch real-time weather information using a weather API. The UI dynamically displays weather details in structured cards for better readability and user experience.

The project follows **MVVM architecture** to ensure clean code separation, scalability, and maintainability.

---

## 🚀 Features

- 🌍 Search weather by city name
- 🌡️ Displays current temperature
- 💧 Shows humidity level
- 🌫️ Weather description (e.g., haze, clear sky, clouds, etc.)
- 🏙️ City name display
- 🎨 Built entirely using Material 3
- 🧠 MVVM Architecture implementation
- 🔄 API data fetching using Retrofit

---

## 📱 How It Works

1. User enters the name of a city.
2. User clicks the **"Check Weather"** button.
3. The app makes an API request using Retrofit.
4. Weather data is fetched and displayed in four cards:
   - 📍 City Name
   - 🌡️ Temperature
   - 💧 Humidity
   - 🌫️ Weather Description

---

## 📸 Screenshots

<p align="center">
  <img src="images/WhatsApp Image 2026-02-11 at 12.56.35 PM (1).jpeg" width="300"/>
  <img src="images/WhatsApp Image 2026-02-11 at 12.56.35 PM.jpeg" width="300"/>
</p>

<p align="center">
  <img src="images/WhatsApp Video 2026-02-11 at 12.56.35 PM.gif" width="300"/>
</p>

---

## 🏗️ Architecture

This project follows **MVVM (Model-View-ViewModel)** architecture:

- **Model** → Data classes representing API response  
- **View** → Jetpack Compose UI  
- **ViewModel** → Handles business logic and state management  
- **Repository Layer** → Handles API communication via Retrofit  

This structure ensures:

- Clear separation of concerns  
- Better scalability  
- Clean and maintainable code  
- Improved testability  

---

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Retrofit**
- **REST API Integration**
- **MVVM Architecture**

---

## 🔧 API Integration

- Weather data is fetched using a REST API.
- Retrofit is used for:
  - Making network requests
  - Parsing JSON responses
  - Handling API responses

---

## 🎯 Project Purpose

This project was built to:

- Practice API integration using Retrofit
- Implement MVVM architecture in a real-world app
- Build a fully functional weather application using modern Android development tools
- Strengthen Jetpack Compose UI skills

---

## 👨‍💻 Author

Developed as part of Android development practice using modern architecture and networking principles.
