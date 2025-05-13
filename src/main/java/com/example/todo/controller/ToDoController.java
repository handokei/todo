package com.example.todo.controller;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService todoService;



    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    //생성
    @PostMapping
    public ResponseEntity<ToDoResponseDto> createTodo(@RequestBody ToDoRequestDto dto) {

        return new ResponseEntity<>(todoService.saveTodo(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ToDoResponseDto> readAllTodo() {
        return todoService.readAllToDo();
    }








}
