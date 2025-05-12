package com.example.todo.dto;

import com.example.todo.entity.ToDo;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Getter
public class ToDoRequestDto {
    private String name;
    private String password;
    private String planTodo;
    private String createDate;
    private String editDate;


}
