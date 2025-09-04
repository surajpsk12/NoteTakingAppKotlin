package com.surajvanshsv.notetakingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.surajvanshsv.notetakingapp.MainActivity
import com.surajvanshsv.notetakingapp.R
import com.surajvanshsv.notetakingapp.adapter.NoteAdapter
import com.surajvanshsv.notetakingapp.databinding.FragmentHomeBinding
import com.surajvanshsv.notetakingapp.databinding.FragmentUpdateNoteBinding
import com.surajvanshsv.notetakingapp.model.Note
import com.surajvanshsv.notetakingapp.viewmodel.NoteViewModel


class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {


    private var _binding : FragmentUpdateNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var currentNote : Note
    // since the udpate note fragment contains arguments in nav
    private val args : UpdateNoteFragmentArgs by navArgs()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel = (activity as MainActivity).noteViewModel
        currentNote = args.note!!
        binding.etNoteTitleUpdate.setText(currentNote.noteTitle)
        binding.etNoteBodyUpdate.setText(currentNote.noteBody)

        val title = binding.etNoteTitleUpdate.text.toString().trim()
        val body = binding.etNoteBodyUpdate.text.toString().trim()

        if(title.isNotEmpty()){
            val note = Note(currentNote.id,title , body )
            notesViewModel.updateNote(note)
            view.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
        } else {
            Toast.makeText(context ,
                "Please enter note title ",
                Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteNote(){
        AlertDialog.Builder(requireActivity()).apply {
            setTitle(
                "Delete Note"
            )
            setMessage("You want to delete this note ? ")
            setPositiveButton("Delete"){_,_ ->
                notesViewModel.deleteNote(currentNote)
                view?.findNavController()?.navigate(R.id.action_updateNoteFragment_to_homeFragment)

            }
            setNegativeButton("Cancel", null )
        }.create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_update_note,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_delete -> {
                deleteNote()
            }
        }

        return super.onOptionsItemSelected(item)
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}