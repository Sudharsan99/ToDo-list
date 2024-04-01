package com.project.todoList.controller;

import com.project.todoList.entity.Todo;
import com.project.todoList.impl.TodoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TodoController {

    @Autowired
    private TodoServiceImpl service;

    @PostMapping("api/todo")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo)
    {
       Todo savetodo = service.addtodo(todo);
       return ResponseEntity.ok(savetodo);
    }

    @GetMapping("api/todo/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable  Long id)
    {
        Todo todo  = service.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("api/todo")
    public ResponseEntity<List<Todo>> getAllTodo()
    {
       List<Todo> todo =  service.getAllTodo();
        return ResponseEntity.ok(todo);
    }

    @PutMapping("api/todo/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable Long id)
    {
        todo.setId(id);
        Todo updateTodo = service.updateTodo(todo);
        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("api/todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id)
    {
         service.deleteTodo(id);
        return ResponseEntity.ok("Records deleted successfully");
    }
}
