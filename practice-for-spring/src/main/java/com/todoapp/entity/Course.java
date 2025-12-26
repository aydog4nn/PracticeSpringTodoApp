package com.todoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "course")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private Long id;

    private String name;

}
