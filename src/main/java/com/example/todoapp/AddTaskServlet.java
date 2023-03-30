package com.example.todoapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddTaskServlet", value = "/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
    private TaskDao taskDao;
    @Override
    public void init() throws ServletException {
        super.init();
        taskDao = new TaskDao();
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        Task task = new Task(description);
        taskDao.createTask(task);
        response.sendRedirect("index.jsp");
    }

}
