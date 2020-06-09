package com.example.todo_app.dao;

import com.example.todo_app.model.Todo;

import java.util.List;

public interface TodoDAO {
    public List<Todo> getTodos();
    public void createTodo(Todo todo);
    public Todo getTodo(int id);
    public void deleteTodo(int id);
}
