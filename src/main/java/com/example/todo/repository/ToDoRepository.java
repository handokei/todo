package com.example.todo.repository;

import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;

import java.util.List;
import java.util.Optional;


public interface ToDoRepository {

    ToDoResponseDto saveTodo(ToDo todo);

    List<ToDoResponseDto> readAllToDo();

    Optional<ToDo> readOneTodo(Long id);

    int updateTodo(Long id, String name, String password, String planTodo,String editDate);

    int deleteTodo(Long id);
}
