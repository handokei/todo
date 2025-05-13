package com.example.todo.dto;

import com.example.todo.entity.ToDo;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
@Getter
public class ToDoResponseDto {

    private Long id;
    private String name;
    private String planTodo;
    private String createDate;
    private String editDate;

    public ToDoResponseDto(ToDo toDo){
        this.id = toDo.getId();
        this.name = toDo.getName();
        this.planTodo = toDo.getPlanTodo();
        this.createDate = toDo.getCreateDate();
        this.editDate = toDo.getEditDate();
    }
}
