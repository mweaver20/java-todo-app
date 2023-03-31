package com.example.todoapp;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    private EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    public void createTask(Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(task);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public Task getTaskById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Task.class, id);
        } finally {
            entityManager.close();
        }
    }


    public List<Task> getTasks(String searchTerm) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Task> tasks = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tasks t WHERE t.taskDescription LIKE '%" + searchTerm + "%'";
            Query query = entityManager.createNativeQuery(queryString, Task.class);
            tasks = query.getResultList();
        } finally {
            entityManager.close();
        }
        return tasks;
    }

    public void deleteTask(int taskId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, taskId);
            if (task != null) {
                entityManager.remove(task);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

}