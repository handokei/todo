package com.example.todo.service;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    @Override
    public ToDoResponseDto saveTodo(ToDoRequestDto dto) {


        //요청 받은 데이터 객체 생성

        ToDo todo = new ToDo(dto.getName(), dto.getPassword(), dto.getPlanTodo());
        return  toDoRepository.saveTodo(todo);
    }

    @Override
    public List<ToDoResponseDto> readAllToDo() {

        List<ToDoResponseDto> allTodos = toDoRepository.readAllToDo();
        return allTodos;
    }

    @Override
    public ToDoResponseDto readOneTodo(Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.readOneTodo(id);
        //NPE 방지 예외 처리
        if (optionalToDo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ToDoResponseDto(optionalToDo.get());
    }

    //이름,할 일 수정
    @Transactional
    @Override
    public ToDoResponseDto updateTodo(Long id, String name,String password, String planTodo) {

        Optional<ToDo> optionalToDo = toDoRepository.readOneTodo(id);

        if (optionalToDo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(name == null || password == null || planTodo == null) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST));
        }

        ToDo todo = optionalToDo.get();

        if (!todo.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"비밀번호 불일치");
        }
        todo.editTodoAndName(planTodo,name);

        int updatedTodo = toDoRepository.updateTodo(id, name, password, planTodo);

        return new ToDoResponseDto(toDoRepository.readOneTodo(id).get());
    }

    @Override
    public ToDoResponseDto deleteTodo(Long id) {

        int deleteTodo = toDoRepository.deleteTodo(id);

        if (deleteTodo == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        toDoRepository.deleteTodo(id);
        return null;
    }
}
