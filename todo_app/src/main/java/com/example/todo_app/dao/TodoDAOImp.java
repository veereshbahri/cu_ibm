package com.example.todo_app.dao;

import com.example.todo_app.model.Todo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository("todoDAO")
public class TodoDAOImp implements TodoDAO{
    public final EntityManager entityManager;

    @Autowired
    public TodoDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Todo> getTodos() {
        Query query=entityManager.createQuery("from Todo");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createTodo(Todo todo) {
        Session session=entityManager.unwrap(org.hibernate.Session.class);
        session.saveOrUpdate(todo);

    }

    @Override
    @Transactional
    public Todo getTodo(int id) {
        return entityManager.find(Todo.class, id);
    }

    @Override
    @Transactional
    public void deleteTodo(int id) {
        entityManager.remove(getTodo(id));

    }
}

