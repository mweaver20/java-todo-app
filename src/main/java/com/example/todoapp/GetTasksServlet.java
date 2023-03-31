package com.example.todoapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetTasksServlet", value = "/GetTasksServlet")
public class GetTasksServlet extends HttpServlet {
    private TaskDao taskDao;
    public void init() throws ServletException {
        super.init();
        taskDao = new TaskDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        List<Task> tasks = taskDao.getTasks(searchTerm);
        System.out.println("Retrieved " + tasks.size() + " tasks from database");
        request.setAttribute("tasks", tasks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
