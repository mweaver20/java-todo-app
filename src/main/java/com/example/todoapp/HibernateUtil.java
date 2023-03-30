package com.example.todoapp;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class HibernateUtil {

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("todoapp"); // replace with your persistence unit name
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}



