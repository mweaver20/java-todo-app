package com.example.todoapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteTaskServlet", value = "/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
    private TaskDao taskDao;
    public void init() throws ServletException {
        super.init();
        taskDao = new TaskDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        taskDao.deleteTask(taskId);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
