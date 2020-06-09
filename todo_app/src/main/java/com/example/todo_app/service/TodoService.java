package com.example.todo_app.service;

import com.example.todo_app.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getTodos();
    public void createTodo(Todo todo);
    public Todo getTodo(int id);
    public void deleteTodo(int id);
}
