package com.example.todo_app.service;

import com.example.todo_app.dao.TodoDAO;
import com.example.todo_app.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("todoService")
public class TodoServiceImp  implements TodoService{

    private TodoDAO todoDAO;

    @Autowired
    public TodoServiceImp(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public List<Todo> getTodos() {
        return todoDAO.getTodos();
    }

    @Override
    public void createTodo(Todo todo) {
        todoDAO.createTodo(todo);
    }

    @Override
    public Todo getTodo(int id) {
        return todoDAO.getTodo(id);
    }

    @Override
    public void deleteTodo(int id) {
        todoDAO.deleteTodo(id);
    }
}
