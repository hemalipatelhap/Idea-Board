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
<table>
<tr>
<td>name</td>
<td>status</td>
<td>priority</td>
</tr>
<%
if(request.getAttribute("tasks") != null){
	List<Task> tasks = (List<Task>) request.getAttribute("tasks");
for(Task task : tasks){%>
	<tr>
	<td><% out.print(task.getName()); %></td>
	<td><% out.print(task.getStatus()); %></td>
	<td><% out.print(task.getPriority()); %></td>
	<td><a href="TaskController?method=<%="update" %>&projectId=<%out.print(request.getAttribute("projectId").toString()); %>&name=<%=task.getName()%>"/>edit</td>
	<td><a href="TaskController?method=<%="delete" %>&projectId=<%out.print(request.getAttribute("projectId").toString()); %>&name=<%=task.getName()%>"/>delete</td>
	</tr>
<%}
}%>
</table>

</body>
</html>