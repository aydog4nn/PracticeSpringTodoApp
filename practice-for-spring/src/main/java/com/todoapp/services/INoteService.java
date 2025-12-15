package com.todoapp.services;

import com.todoapp.dto.DtoNote;
import com.todoapp.dto.DtoNoteIU;
import com.todoapp.entity.Note;

import java.util.List;

public interface INoteService {

    public List<DtoNote> getAllNotes();

    public DtoNote addNote(DtoNoteIU dtoNoteIU);

    public void deleteNote(Integer id);

    public DtoNote findNoteById(Integer id);

    public DtoNote updateNote(Integer id,DtoNoteIU updateNoteIU);


}
