package com.example.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@AllArgsConstructor
public class ToDo {

    private Long id;
    private String name;
    private String password;
    private String planTodo;
    private String createDate;
    private String editDate;

    public ToDo ( String name, String password, String planTodo){
        this.name = name;
        this.password = password;
        this.planTodo = planTodo;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        this.createDate = simpleDateFormat.format(new Date());
        this.editDate = simpleDateFormat.format(new Date());
    }
    public ToDo (String name, String password, String planTodo, String createDate){
        this.name = name;
        this.password = password;
        this.planTodo = planTodo;
        this.createDate = createDate;
        this.editDate = editDate;
    }


    public void editTodoAndName(String planToDo, String name) {
        this.planTodo = planToDo;
        this.name = name;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        this.editDate = simpleDateFormat.format(new Date());
    }
}
