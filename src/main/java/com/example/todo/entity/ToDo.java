package com.example.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class ToDo {

    private Long id;
    private String name;
    private String password;
    private String planTodo;
    private String createDate;
    private String editDate;
}
