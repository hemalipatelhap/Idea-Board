<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Project <%out.print(request.getAttribute("projectId").toString()); %></p>
<ul>
<li><a href="ProjectController?method=<%="viewMembers" %>&projectId=<%out.print(request.getAttribute("projectId").toString()); %>">members</a></li>
<li><a href="TaskController?method=<%="viewAll" %>&projectId=<%out.print(request.getAttribute("projectId").toString());%>">tasks</a></li>
<li><a href="TaskController?method=<%="create" %>&projectId=<%out.print(request.getAttribute("projectId").toString()); %>">create task</a></li>
</ul>
</body>
</html>