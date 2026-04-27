# 😉 Contact List App (Android - Kotlin)

## 🧾 Overview

The **Contact List App** is a simple Android application built using **Kotlin**.
It demonstrates fundamental Android development concepts such as UI design, navigation, and dynamic data handling.

This project is ideal for beginners who want to understand how real Android apps are structured and how different components interact with each other.

---

## 🎯 Features

* 📋 Display a list of contacts using RecyclerView
* ➕ Add a new contact via Floating Action Button (FAB)
* 👁 View detailed contact information on a separate screen
* 🔙 Smooth navigation between activities
* 🔔 Toast message confirmation on adding a contact

---
## 📸 Screenshots

| Contact List Screen                          | Add Contact Screen                          | Contact Detail Screen                            |
| -------------------------------------------- | ------------------------------------------- | ------------------------------------------------ |
| ![Contact List](screenshots/main_screen.png) | ![Add Contact](screenshots/add_contact.png) | ![Contact Detail](screenshots/detail_screen.png) |

---



## 🧠 App Architecture

```
MainActivity (Contact List Screen)
        ↓
RecyclerView + Adapter
        ↓
contact_item.xml (UI for each item)

Click Item → ContactDetailActivity

FAB ➕ → AddContactActivity → Return Data → Update List
```

---

## 🧱 Project Structure

```
com.example.contact_list_app
│
├── MainActivity.kt
├── AddContactActivity.kt
├── ContactDetailActivity.kt
│
├── Contact.kt              # Data Model
├── ContactAdapter.kt      # RecyclerView Adapter
│
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_add_contact.xml
    │   ├── activity_contact_detail.xml
    │   └── contact_item.xml
    │
    └── drawable/
        ├── person_icon.jpg
        └── back_arrow.xml
```

---

## 🔹 Key Components

### 1. Contact Model (`Contact.kt`)

Defines the structure of a contact:

```kotlin
data class Contact(
    val image: Int,
    val name: String,
    val phone: String
)
```

---

### 2. RecyclerView & Adapter

RecyclerView is used to efficiently display a scrollable list of contacts.

**Adapter Responsibilities:**

* Inflate item layout
* Bind data to views
* Handle item clicks

**Important Methods:**

* `onCreateViewHolder()` → Inflate layout
* `onBindViewHolder()` → Bind data
* `getItemCount()` → Return list size

---

### 3. MainActivity

Handles:

* Initializing RecyclerView
* Loading and updating contact list
* Handling FAB click
* Receiving data from AddContactActivity

---

### 4. AddContactActivity

* Accepts user input (name & phone)
* Sends data back using Intent

```kotlin
setResult(RESULT_OK, intent)
finish()
```

---

### 5. ContactDetailActivity

Displays selected contact details:

```kotlin
val name = intent.getStringExtra("name")
```

---

### 6. Floating Action Button (FAB)

Used to trigger the "Add Contact" screen.

---

## 🎨 UI Design

* Material Design principles
* CardView for contact items
* ConstraintLayout for responsive layout
* Clean and user-friendly interface

---

## 🔄 App Flow

```
App Launch
   ↓
MainActivity (Contact List)
   ↓
Click Contact → ContactDetailActivity
   ↓
Back → MainActivity

FAB ➕ Click
   ↓
AddContactActivity
   ↓
Enter Details
   ↓
Save Contact
   ↓
Return to MainActivity
   ↓
Updated Contact List
```

---

## ⚠️ Challenges Solved

* RecyclerView spacing issues
* Drawable resource handling errors
* Intent-based data passing
* Activity result handling
* ConstraintLayout warnings

---

## 🚀 Technologies Used

* Kotlin
* Android SDK
* RecyclerView
* CardView
* ConstraintLayout
* Intents

---

## 🔮 Future Improvements

* 💾 Integrate Room Database (persistent storage)
* 🔍 Search functionality
* ✏ Edit contacts
* 🗑 Delete contacts
* 📞 Direct call feature
* ☁ Firebase integration

---

## 🧠 Learning Outcomes

* Understanding RecyclerView & Adapter pattern
* Activity navigation using Intents
* UI design using ConstraintLayout
* Handling user input
* Managing app flow and lifecycle

---

## 💪 Conclusion

This project demonstrates a complete Android app workflow including:

✔ UI Design
✔ Navigation
✔ Data Handling
✔ User Interaction

It provides a strong foundation for building real-world Android applications.

---

## 📌 Author

Developed by *Mayur Hiware*
Feel free to contribute or improve this project!

---
