<%@page import="java.util.List"%>
<%@page import="com.example.todoapp.TaskDao"%>
<%@page import="com.example.todoapp.Task"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<table>
    <thead>
    <tr>
        <th>Task</th>
    </tr>
    </thead>
    <tbody>
    <%
        TaskDao taskDao = new TaskDao();
        List<Task> tasks = taskDao.getAllTasks();
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
<form action="AddTaskServlet" method="POST">
    <input type="text" name="description" placeholder="Task description">
    <button type="submit">Add Task</button>
</form>
</body>
</html>
