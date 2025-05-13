package com.example.todo.service;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    @Override
    public ToDoResponseDto saveTodo(ToDoRequestDto dto) {

        //요청받은 데이터로 객체 생성 ID 없음.
        ToDo todo = new ToDo(dto.getName(), dto.getPassword(), dto.getPlanTodo(), dto.getCreateDate(), dto.getEditDate());

        ToDo savedToDo = toDoRepository.saveToDo(todo);

        return new ToDoResponseDto(savedToDo);
    }

    @Override
    public List<ToDoResponseDto> readAllToDo() {

        List<ToDoResponseDto> allTodos = toDoRepository.readAllToDo();
        return allTodos;
    }
}
