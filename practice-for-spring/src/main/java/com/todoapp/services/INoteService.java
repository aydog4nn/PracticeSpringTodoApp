package com.todoapp.services;

import com.todoapp.entity.Note;

import java.util.List;

public interface INoteService {

    public List<Note> getAllNotes(Note note);

    public Note addNote(Note note);

    public void deleteNote(Integer id);

    public Note findNoteById(Integer id);

    public Note updateNote(Integer id,Note updateNote);


}
