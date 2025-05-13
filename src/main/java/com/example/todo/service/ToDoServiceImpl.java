package com.example.todo.service;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public ToDoResponseDto readOneTodo(Long id) {
        ToDo todo =toDoRepository.readOneTodo(id);
        //NPE 방지 예외 처리
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ToDoResponseDto(todo);
    }

    //이름,할 일 수정
    @Override
    public ToDoResponseDto updateTodo(Long id, String name,String password, String planToDo,String editDate) {


        ToDo todo = toDoRepository.readOneTodo(id);

        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(name == null || password == null || planToDo == null) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST));
        }

        todo.editTodoAndName(planToDo,name); //
        ToDo updateTodo = toDoRepository.updateTodo(todo);
        return new ToDoResponseDto(updateTodo);
    }

    @Override
    public ToDoResponseDto deleteTodo(Long id) {
        ToDo todo = toDoRepository.readOneTodo(id);

        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        toDoRepository.deleteTodo(id);
        return null;
    }
}
