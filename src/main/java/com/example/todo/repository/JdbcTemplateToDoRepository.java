package com.example.todo.repository;

import com.example.todo.dto.ToDoResponseDto;
import com.example.todo.entity.ToDo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateToDoRepository implements ToDoRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateToDoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ToDoResponseDto saveTodo(ToDo todo) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("todo").usingGeneratedKeyColumns("id");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("name",todo.getName());
        parameters.put("password",todo.getPassword());
        parameters.put("planTodo",todo.getPlanTodo());
        //날짜
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now = simpleDateFormat.format(new Date());
        parameters.put("createDate", now);
        parameters.put("editDate",now);

        //저장 후 생성된 키 값 Number 타입으로 변환 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        //리스폰 Dto
        return new ToDoResponseDto(key.longValue(),todo.getName(),todo.getPlanTodo(),now,now);
    }

    @Override
    public List<ToDoResponseDto> readAllToDo() {
        return List.of();
    }

    @Override
    public ToDo readOneTodo(Long id) {
        return null;
    }

    @Override
    public ToDo updateTodo(ToDo todo) {
        return null;
    }

    @Override
    public void deleteTodo(Long id) {

    }
}
