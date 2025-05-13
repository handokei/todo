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

        //요청받은 데이터로 객체 생성 ID 없음.
        Long todoId = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;
        todo.setId(todoId);

        todoList.put(todoId,todo);

        return todo;
    }

    @Override
    public List<ToDoResponseDto> readAllToDo() {

        //리스트 초기화
        List<ToDoResponseDto> allTodo = new ArrayList<>();

        for (ToDo todo : todoList.values()) {
            ToDoResponseDto responseDto = new ToDoResponseDto(todo);
            allTodo.add(responseDto);
        }
     return allTodo;
    }

    @Override
    public ToDo readOneTodo(Long id) {

        return todoList.get(id);
    }
}
