<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Idea,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Idea> projects = null;
if(request.getAttribute("projects") != null){
	
	
	 projects =(List<Idea>) request.getAttribute("projects");

}
%>
<table>
<tr>
<td>id</td>
<td>title</td>
<td>view</td>
</tr>
<%
if(projects != null){
for(Idea idea : projects){%>
	<tr>
	<td><% out.print(idea.getIdeaId()); %></td>
	<td><% out.print(idea.getTitle()); %></td>
	<td><a href="ProjectController?method=<%="viewProject" %>&ideaId=<%=idea.getIdeaId() %>"/>view</td>
	</tr>
<%}
}%>
</table>

</body>
</html>