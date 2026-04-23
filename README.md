# 📱 Offline Quiz App

An Android application built using **Kotlin** and **Jetpack Compose** that allows users to attempt grammar-based MCQ questions offline.

---

## 🚀 Features

- 🧠 5 Grammar-based MCQ questions  
- ✅ Answer selection with highlight  
- 📊 Score tracking  
- 🎉 Result dialog at the end  
- 🔄 Restart and Exit options  
- 📶 Works completely offline  
- 🎨 Clean and modern UI  

---

## 🏗️ Architecture

This project follows **MVVM (Model-View-ViewModel)** architecture:

- **Model** → Question data  
- **ViewModel** → Handles state & business logic  
- **View (UI)** → Built using Jetpack Compose  

---

## 🧠 State Management

- Used `mutableStateOf` and `mutableStateListOf`
- Ensures reactive UI updates in Compose

---

## 💾 Data Handling

- Currently using a **Repository pattern** with mock data  
- Easily extendable to **Room Database** for full offline storage  

---

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **MVVM Architecture**
- **Material 3 UI**

---

## 📸 Screens

- Start Screen  
- Quiz Screen  
- Result Dialog  

---

## 🎥 Demo Video

👉 *(Add your video link here)*

---

```
## 📂 Project Structure
com.skyrist.offlinequizapp
│
├── data
│ ├── Question.kt
│ └── QuestionRepository.kt
│
├── ui
│ ├── screen
│ │ ├── StartScreen.kt
│ │ └── QuizScreen.kt
│ │
│ └── viewmodel
│ └── QuizViewModel.kt
│
└── MainActivity.kt
```

---

## 🔮 Future Improvements

- Room Database integration  
- Firebase / API-based questions  
- AI-powered question generation  
- Timer-based quiz  

---

## 🙌 Developer

**Sanstubh Katiyar**

---

## ⭐ Note

This project was developed as part of an internship assignment to demonstrate:
- Clean architecture  
- State management  
- UI design using Compose  
- Problem-solving approach  
