package com.example.todo_app.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Cant be null")
    @Size(min=1, message="is required")
    @Column(name = "description")
    private String description;
    @NotNull(message = "Date needs to be there")
    @Size(min=1, message="is required")
    @Column(name = "todo_date")
    private String todo_date;

    public Todo() {
    }
    public Todo(String description, String todo_date)
    {
        this.description=description;
        this.todo_date=todo_date;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", todo_date=" + todo_date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTodo_date() {
        return todo_date;
    }

    public void setTodo_date(String todo_date) {
        this.todo_date = todo_date;
    }
}
