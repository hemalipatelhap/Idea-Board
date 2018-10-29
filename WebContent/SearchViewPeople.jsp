<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Idea,com.ideaboard.model.User,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<User> users =(List<User>)request.getAttribute("usersList"); %>
<table>
<tr>
<td>First Name</td>
<td>Last Name</td>
<td> View</td>
</tr>
<%
if(users != null){
for(User user : users){%>
	<tr>
	<td><% out.print(user.getFirstName()); %></td>
	<td><% out.print(user.getLastName()); %></td>
	<td><a href="SearchIdeaController?method=<%="viewPeople" %>&title=<%=user.getNetId() %>"/>view</td>
	
	</tr>
<%}
}%>
</table>
</body>
</html>