package com.example.todo.repository;

import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class ToDoRepositoryImpl implements ToDoRepository {

    private final Map<Long, ToDo> todoList = new HashMap<>();

    @Override
    public ToDo saveToDo(ToDo todo) {

        Long todoId = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;
        todo.setId(todoId);

        todoList.put(todoId,todo);

        return todo;
    }

    @Override
    public List<ToDoResponseDto> readAllToDo() {

        List<ToDoResponseDto> allTodo = new ArrayList<>();

        for (ToDo todo : todoList.values()) {
            ToDoResponseDto responseDto = new ToDoResponseDto(todo);
            allTodo.add(responseDto);
        }
     return allTodo;
    }
}
