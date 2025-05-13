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
    //전체조회
    @GetMapping
    public List<ToDoResponseDto> readAllTodo() {

        return todoService.readAllToDo();
    }

    //단건조회
    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> readOneTodo(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.readOneTodo(id), HttpStatus.OK);
    }

    //일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> updateTodo(
            @PathVariable Long id,
            @RequestBody ToDoRequestDto dto) {
        return new ResponseEntity<>(todoService.updateTodo(id,dto.getName(), dto.getPassword(), dto.getPlanTodo(), dto.getEditDate()),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }








}
