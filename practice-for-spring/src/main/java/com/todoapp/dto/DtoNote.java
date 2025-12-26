package com.todoapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoNote {

    private Integer id;

    private String title;

    private String content;

    private List<DtoCourse> courses = new ArrayList<>();

}
