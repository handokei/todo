package com.example.todo.contorller;

import com.example.todo.dto.ToDoRequestDto;
import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final Map<Long, ToDo> todoList = new HashMap<>();

    @PostMapping
    public ResponseEntity<ToDoResponseDto> createTodo(@RequestBody ToDoRequestDto dto) {

        //식별자 1씩 증가하도록
        long todoUserId = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;
        //요청 받은 데이터 객체 생성
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String now = simpleDateFormat.format(new Date());

        ToDo toDo = new ToDo(todoUserId, dto.getName(), dto.getPassword(), dto.getPlanTodo(), now, now);

        //Inmemory 데이터베이스 저장
        todoList.put(todoUserId, toDo);

        return new ResponseEntity<>(new ToDoResponseDto(toDo), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ToDoResponseDto> readAllTodo() {
        //리스트 초기화
        List<ToDoResponseDto> responseList = new ArrayList<>();
        // HashMap<ToDo> => List<TodoresponseDto>
        for (ToDo toDo : todoList.values()) {
            ToDoResponseDto responseDto = new ToDoResponseDto(toDo);
            responseList.add(responseDto);

        }
        return responseList;
    }






}
