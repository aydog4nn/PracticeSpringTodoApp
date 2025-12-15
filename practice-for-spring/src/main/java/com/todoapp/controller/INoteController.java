package com.todoapp.controller;

import com.todoapp.dto.DtoNote;
import com.todoapp.dto.DtoNoteIU;
import com.todoapp.entity.Note;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface INoteController {

    public List<DtoNote> getAllNotes();

    public DtoNote addNote(DtoNoteIU dtoNoteIU);

    public DtoNote findNoteById(Integer id);

    public void deleteNote(Integer id);

    public DtoNote updateNote(Integer id,DtoNoteIU updatedNoteIU);
}
