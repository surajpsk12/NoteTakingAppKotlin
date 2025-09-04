# 📝 NoteTakingApp (Google Keep Clone)

> **An Android application built with Kotlin that allows users to create, view, update, delete, and search notes. A Google Keep Clone. It demonstrates modern Android development practices including Room, Navigation Component, and MVVM architecture.**

---
App Download Link : https://drive.google.com/file/d/1wqoeXM_oe_6kF_Hwf6MK-dslzSxewtEK/view?usp=sharing


## 🚀 Features

-   **Create & Edit Notes:** Allows users to create new notes and modify existing ones with a title and content.
-   **View Notes:** Displays all saved notes in a list or grid format.
-   **Delete Notes:** Provides functionality to remove unwanted notes.
-   **Search Notes:** Enables users to search through their notes based on keywords.
-   **Local Data Persistence:** Uses Room persistence library to store notes locally on the device.
-   **Navigation:** Utilizes Jetpack Navigation Component for navigating between different screens/fragments.

---

## 🛠️ Tech Stack

-   **Language:** Kotlin
-   **UI:** XML
-   **Architecture:**  MVVM (Model-View-ViewModel)
-   **Core Components:** Android SDK (Activities, Fragments)
-   **Jetpack Libraries:**
    -   Room Persistence Library (`NoteDatabase.kt`, `NoteDAO.kt`)
    -   Navigation Component (`nav_graph.xml`)
    -   ViewModel (often used with Repository and Room)
    -   LiveData or Kotlin Flow (for observing data changes)
    -   Coroutines (for background tasks like database operations)
-   **UI Elements:** `RecyclerView` (for displaying notes), `EditText` (for note input), `SearchView` or `EditText` for search, `FloatingActionButton` (for adding notes), `ImageViews`/`Buttons` for actions like delete.

---

## 📁 Project Structure 

```
com.surajvanshsv.notetakingapp/
├── MainActivity.kt             # Main activity hosting the NavHostFragment
├── ui/                         # Package for UI-related classes (Fragments, Adapters)
│   ├── HomeFragment.kt         # Fragment to display list of notes, handle search
│   ├── AddEditNoteFragment.kt  # Fragment for creating or editing a note
│   └── NoteAdapter.kt          # RecyclerView Adapter for notes list
├── database/
│   ├── Note.kt                 # Room Entity representing a note
│   ├── NoteDAO.kt              # Data Access Object for Room operations
│   └── NoteDatabase.kt         # Room Database class
├── repository/
│   └── NoteRepository.kt       # Repository to abstract data source logic
├── viewmodel/                  # Package for ViewModel classes
│   └── NoteViewModel.kt        # ViewModel to manage UI-related data for notes
├── res/
│   ├── layout/
│   │   ├── activity_main.xml       # Contains NavHostFragment
│   │   ├── fragment_home.xml       # Layout for HomeFragment (list, search)
│   │   ├── fragment_add_edit_note.xml # Layout for AddEditNoteFragment
│   │   └── item_note_layout.xml    # Layout for a single note item in the RecyclerView
│   ├── drawable/
│   │   ├── ic_add.xml              
│   │   ├── ic_search.xml
│   │   └── ic_delete.xml
│   ├── menu/                     # For options menus (e.g., search, sort)
│   │   └── home_menu.xml
│   ├── navigation/
│   │   └── nav_graph.xml         # Defines navigation flow between fragments
│   └── values/                   # colors.xml, strings.xml, styles.xml, themes.xml
├── build.gradle.kts (Module :app) # Gradle build file with dependencies
└── AndroidManifest.xml
```


---

## ⚙️ Installation & Run

1.  **Clone this repo:**
    ```bash
    git clone https://github.com/surajpsk12/NoteTakingAppKotlin.git
    cd NoteTakingAppKotlin
    ```

2.  **Open in Android Studio.**

3.  **Ensure necessary dependencies (Room, Navigation, ViewModel, etc.) are correctly set up in your `app/build.gradle.kts` file.** (These are likely already present based on your file structure).

4.  **Run the app on an emulator or physical device.**

---

## ✨ Key Concepts Demonstrated

-   **Room Persistence:** Implementation of `Note` entity, `NoteDAO` for database queries, and `NoteDatabase` setup.
-   **MVVM Architecture:** Separation of concerns using `ViewModel`, `NoteRepository`, and UI controllers (Fragments).
-   **Jetpack Navigation Component:** Using `nav_graph.xml` to define navigation paths and `NavController` to navigate between fragments (e.g., from a list view to an add/edit view).
-   **RecyclerView:** Efficiently displaying a list of notes using an `Adapter`.
-   **Coroutines & LiveData/Flow:** Handling asynchronous database operations and observing data changes to update the UI reactively.
-   **CRUD Operations:** Implementing Create, Read, Update, and Delete functionalities for notes.
-   **Search Functionality:** Filtering notes based on user input.

---

## ✨ Future Enhancements

-   ✅ Add sorting options for notes (by date, title, etc.).
-   ✅ Implement categories or tags for notes.
-   ✅ Add password protection or biometric authentication for the app/notes.
-   ✅ Implement cloud synchronization (e.g., Firebase Firestore).
-   ✅ Add rich text editing capabilities (bold, italics, lists).
-   ✅ Implement reminders for notes.
-   ✅ Add unit and UI tests.

---

## 🤝 Contribution

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change or improve.

---

## 📜 License

MIT © 2024 [Suraj Kumar](https://github.com/surajpsk12)

---

## 🌐 Connect With Me

*   🔗 [LinkedIn - Suraj Kumar](https://www.linkedin.com/in/surajvansh12/)
*   💻 [GitHub - surajpsk12](https://github.com/surajpsk12)
