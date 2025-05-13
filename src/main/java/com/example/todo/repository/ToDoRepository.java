package com.example.todo.repository;

import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ToDoRepository {

    ToDoResponseDto saveTodo(ToDo todo);

    List<ToDoResponseDto> readAllToDo();

    ToDo readOneTodo(Long id);

    ToDo updateTodo(ToDo todo);

    void deleteTodo(Long id);
}
