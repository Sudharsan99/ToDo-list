package com.project.todoList.service;

import com.project.todoList.entity.Todo;

import java.util.List;

public interface TodoService {

    Todo addtodo(Todo todo);

    Todo getTodo(Long id);

    List<Todo> getAllTodo();

    Todo  updateTodo(Todo todo);

    void deleteTodo(Long id);

//    Todo completeTodo(Long id);
}
