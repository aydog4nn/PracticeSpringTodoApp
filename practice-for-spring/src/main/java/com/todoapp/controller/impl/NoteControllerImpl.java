package com.todoapp.controller.impl;

import com.todoapp.controller.INoteController;
import com.todoapp.entity.Note;
import com.todoapp.services.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/notes")
public class NoteControllerImpl implements INoteController {

    @Autowired
    private INoteService noteService;

    @GetMapping(path = "/get-all-notes")
    @Override
    public List<Note> getAllNotes(Note note) {
        return noteService.getAllNotes(note);
    }

    @PostMapping(path = "/add-note")
    @Override
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    @GetMapping(path = "/find/{id}")
    @Override
    public Note findNoteById(@PathVariable(name = "id") Integer id) {
        return noteService.findNoteById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteNote(@PathVariable(name = "id") Integer id) {
        noteService.deleteNote(id);
    }

    @PutMapping(path = "/update-note/{id}")
    @Override
    public Note updateNote(@PathVariable(name = "id") Integer id,@RequestBody Note updatedNote) {
        return noteService.updateNote(id,updatedNote);
    }
}
