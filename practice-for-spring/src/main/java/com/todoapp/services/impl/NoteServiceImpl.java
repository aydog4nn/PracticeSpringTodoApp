package com.todoapp.services.impl;

import com.todoapp.dto.DtoCourse;
import com.todoapp.dto.DtoNote;
import com.todoapp.dto.DtoNoteIU;
import com.todoapp.entity.Course;
import com.todoapp.entity.Note;
import com.todoapp.repository.NoteRepository;
import com.todoapp.services.INoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class NoteServiceImpl implements INoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<DtoNote> getAllNotes() {
       List<DtoNote> dtoList = new ArrayList<>();
       List<Note> noteList = noteRepository.findAll();

       for (Note note : noteList){
           DtoNote dto = new DtoNote();
           BeanUtils.copyProperties(note,dto);
           dtoList.add(dto);
       }
       return dtoList;
    }

    @Override
    public DtoNote addNote(DtoNoteIU dtoNoteIU) {
        DtoNote response = new DtoNote();
        Note note = new Note();

        BeanUtils.copyProperties(dtoNoteIU,note);
        Note dbNote = noteRepository.save(note);
        BeanUtils.copyProperties(dbNote,response);
        return response;
    }

    @Override
    public DtoNote findNoteById(Integer id) {
       DtoNote dtoNote = new DtoNote();
       Optional<Note> optional  = noteRepository.findById(id);
       if (optional.isEmpty()) {
           return null;
       }

       Note dbNote  = optional.get();
       BeanUtils.copyProperties(dbNote,dtoNote);

       if (dbNote.getCourses()!= null && !dbNote.getCourses().isEmpty()) {
           for (Course course : dbNote.getCourses()) {
               DtoCourse dtoCourse = new DtoCourse();
               BeanUtils.copyProperties(course, dtoCourse);

               dtoNote.getCourses().add(dtoCourse);

           }
       }
       return dtoNote;
    }


    @Override
    public DtoNote updateNote(Integer id, DtoNoteIU updateNoteIU) {
        DtoNote dto = new DtoNote();
        Optional<Note> optional =  noteRepository.findById(id);
        if (optional.isPresent()) {
            Note dbNote = optional.get();
            dbNote.setTitle(updateNoteIU.getTitle());
            dbNote.setContent(updateNoteIU.getContent());

            Note updatedNote = noteRepository.save(dbNote);
            BeanUtils.copyProperties(updatedNote,dto);
            return dto;
        }
        return null;
    }

    @Override
    public void deleteNote(Integer id) {
        Optional<Note> optional =  noteRepository.findById(id);
        optional.ifPresent(note -> noteRepository.delete(note));
   }
}
