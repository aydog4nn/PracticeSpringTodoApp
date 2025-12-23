package com.todoapp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoNoteIU {

    @NotEmpty(message = "Bu alan boş bırakılamaz..")
    @Size(min = 5,max = 20)
    private String title;

    @NotEmpty(message = "İçerik alanı boş bırakılamaz.")
    @Size(min = 5,max = 20)
    private String content;

    private Date creationDate;




}
