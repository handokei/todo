package com.example.todo.service;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;

import java.util.List;

public interface ToDoService {

    ToDoResponseDto saveTodo(ToDoRequestDto dto);

    List<ToDoResponseDto> readAllToDo() ;

    ToDoResponseDto readOneTodo(Long id);

    ToDoResponseDto updateTodo(Long id, String name, String password,String planToDo,String editDate);

    ToDoResponseDto deleteTodo(Long id);
}
