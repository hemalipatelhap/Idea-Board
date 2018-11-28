<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Task,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Task task = null;

int priority = 0;
int status = 0;
if(request.getAttribute("task") != null  ){
	  task = (Task) request.getAttribute("task");
	}%>
	
<form action="TaskController?method=<%="update" %>&projectId=<%out.print(request.getAttribute("projectId").toString()); %>" method = "post">
<table>
<tr><td>Name</td><td><input type="text" name="name"  value="<%out.print(task.getName());%>"/></td></tr>
<tr>
<td>Status</td>
<td>
<input type = "radio" name="status" value="1" ${task.getStatus().equals("started") ? 'checked' : ''}/>started
<input type = "radio" name="status" value="2" ${task.getStatus().equals("in progress") ? 'checked' : ''}/>in progress
<input type = "radio" name="status" value="3" ${task.getStatus().equals("complete") ? 'checked' : ''}/>complete
</td>
</tr>
<tr>
<td>Priority</td>
<td>
<input type = "radio" name="priority" value="1" ${task.getPriority() == 1 ? 'checked' : ''}/>1
<input type = "radio" name="priority" value="2" ${task.getPriority() == 2 ? 'checked' : ''}/>2
<input type = "radio" name="priority" value="3" ${task.getPriority() == 3 ? 'checked' : ''}/>3
<input type = "radio" name="priority" value="4" ${task.getPriority() == 4 ? 'checked' : ''}/>4
<input type = "radio" name="priority" value="5" ${task.getPriority() == 5 ? 'checked' : ''}/>5
</td>
</tr>

<tr><td><input type="submit" value="update"/></td></tr>
</table>
</form>
</body>
</html>