package com.todoapp.controller;

import com.todoapp.entity.Note;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface INoteController {

    public List<Note> getAllNotes(Note note);

    public Note addNote(Note note);

    public Note findNoteById(Integer id);

    public void deleteNote(Integer id);

    public Note updateNote(Integer id,Note updatedNote);
}
