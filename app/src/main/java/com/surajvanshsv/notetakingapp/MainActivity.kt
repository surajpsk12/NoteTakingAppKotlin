package com.surajvanshsv.notetakingapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.surajvanshsv.notetakingapp.database.NoteDatabase
import com.surajvanshsv.notetakingapp.databinding.ActivityMainBinding
import com.surajvanshsv.notetakingapp.repository.NoteRepository
import com.surajvanshsv.notetakingapp.viewmodel.NoteViewModel
import com.surajvanshsv.notetakingapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        setUpUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }

    private fun setUpUI() {
        // Enable edge-to-edge with proper Google Keep styling
        window.statusBarColor = getColor(R.color.keep_background)
        window.navigationBarColor = getColor(R.color.keep_background)
    }
}