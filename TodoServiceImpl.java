package com.project.todoList.impl;

import com.project.todoList.entity.Todo;
import com.project.todoList.repository.TodoRepo;
import com.project.todoList.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepo repo;

    @Override
    public Todo addtodo(Todo todo) {
        return repo.save(todo);
    }

    @Override
    public Todo getTodo(Long id) {
        Optional<Todo> getTodo = repo.findById(id);
        return  getTodo.get();
    }

    @Override
    public List<Todo> getAllTodo() {
         return repo.findAll();
    }

    @Override
    public Todo updateTodo(Todo todo) {
      Todo existingTodo = repo.findById(todo.getId()).get();

      existingTodo.setId(todo.getId());
      existingTodo.setName(todo.getName());
      existingTodo.setDescription(todo.getDescription());
      existingTodo.setCompleted(todo.isCompleted());

      Todo updatedTodo = repo.save(existingTodo);
        return updatedTodo;
    }

    @Override
    public void deleteTodo(Long id) {
        repo.deleteById(id);
    }

}
