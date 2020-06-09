package com.example.todo_app.controller;

import com.example.todo_app.model.Todo;
import com.example.todo_app.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private TodoService service;


    public TodoController(TodoService service) {
        this.service = service;
    }
    @RequestMapping("/listTodos")
    public String listTodos(Model model)
    {
        model.addAttribute("todos",service.getTodos());
        return "todo-list";
    }
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        model.addAttribute("todo",new Todo());
        return "todo-form";
    }
    @RequestMapping("/saveTodo")
    public String saveTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "todo-form";
        }
        else{
            service.createTodo(todo);
            return "redirect:/todo/listTodos";
        }
    }
    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,Model model)
    {
        Todo todo=service.getTodo(id);
        model.addAttribute("todo",todo);
        return "todo-form";
    }
    @RequestMapping("/updateTodo")
    public String updateTodo(@ModelAttribute("todo") Todo todo)
    {
        service.createTodo(todo);
        return "redirect:/todo/listTodos";
    }
    @RequestMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("id") int id)
    {
        service.deleteTodo(id);
        return "redirect:/todo/listTodos";
    }
}
