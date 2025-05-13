package com.example.todo.service;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    @Override
    public ToDoResponseDto saveTodo(ToDoRequestDto dto) {


        //요청 받은 데이터 객체 생성
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String now = simpleDateFormat.format(new Date());
        ToDo todo = new ToDo(dto.getName(), dto.getPassword(), dto.getPlanTodo(),now,now);

        ToDo savedToDo = toDoRepository.saveToDo(todo);

        return new ToDoResponseDto(savedToDo);
    }

    @Override
    public List<ToDoResponseDto> readAllToDo() {

        List<ToDoResponseDto> allTodos = toDoRepository.readAllToDo();
        return allTodos;
    }
}
