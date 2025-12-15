package com.todoapp.controller.impl;

import com.todoapp.controller.INoteController;
import com.todoapp.dto.DtoNote;
import com.todoapp.dto.DtoNoteIU;
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
    public List<DtoNote> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping(path = "/add-note")
    @Override
    public DtoNote addNote(@RequestBody DtoNoteIU dtoNoteIU) {
        return noteService.addNote(dtoNoteIU);
    }

    @GetMapping(path = "/find/{id}")
    @Override
    public DtoNote findNoteById(@PathVariable Integer id) {
        return noteService.findNoteById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
    }

    @PutMapping(path = "/update-note/{id}")
    @Override
    public DtoNote updateNote(@PathVariable Integer id, @RequestBody DtoNoteIU updatedNoteIU) {
        return noteService.updateNote(id,updatedNoteIU);
    }
}
