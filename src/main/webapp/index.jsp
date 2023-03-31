<%@page import="java.util.List"%>
<%@page import="com.example.todoapp.TaskDao"%>
<%@page import="com.example.todoapp.Task"%>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<form action="AddTaskServlet" method="POST">
    <input type="text" name="description" placeholder="Task description">
    <button type="submit">Add Task</button>
</form>
<br>
<form action="GetTasksServlet" method="GET">
    <input type="text" name="searchTerm" placeholder="Task description">
    <button type="submit">Search tasks</button>
</form>
<br>
<table>
    <thead>
    <tr>
        <th>Task</th>
    </tr>
    </thead>
    <tbody>
    <%
        TaskDao taskDao = new TaskDao();
        String searchTerm = request.getParameter("searchTerm");
        List<Task> tasks = new ArrayList<>();
        if(searchTerm != null && !searchTerm.isEmpty()) {
            tasks = taskDao.getTasks(searchTerm);
        }
        for (Task task : tasks) {
    %>
    <tr>
        <td><%= task.getTaskId()%></td>
        <td><%= task.getTaskDescription()%></td>
        <td>
            <form action="DeleteTaskServlet" method="post">
                <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<br>
</body>
</html>
