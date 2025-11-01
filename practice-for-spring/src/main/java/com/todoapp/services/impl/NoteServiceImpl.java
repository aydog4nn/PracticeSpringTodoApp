package com.todoapp.services.impl;

import com.todoapp.entity.Note;
import com.todoapp.repository.NoteRepository;
import com.todoapp.services.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements INoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes(Note note) {
       return noteRepository.findAll();
    }

    @Override
    public Note addNote(Note note) {
        if (note != null) {

            return noteRepository.save(note);
        }
        return null;
    }

    @Override
    public Note findNoteById(Integer id) {
        Optional<Note> optional = noteRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Note updateNote(Integer id, Note updateNote) {
        Note dbNote = findNoteById(id);
        if (dbNote != null) {
            dbNote.setTitle(updateNote.getTitle());
            dbNote.setContent(updateNote.getContent());
            dbNote.setCreationDate(updateNote.getCreationDate());

            return noteRepository.save(dbNote);
        }
        return null;
    }

    @Override
    public void deleteNote(Integer id) {
        Note dbNote = findNoteById(id);
        if (dbNote != null){
            noteRepository.delete(dbNote);
        }
    }
}
