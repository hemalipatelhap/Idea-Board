<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Idea,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchViewIdea</title>
</head>
<body>
<%
List<Idea> ideas = null;

	
	//IdeaDao  ideaDao = new IdeaDao();
	 ideas =(List<Idea>)request.getAttribute("ideaList");
     out.print(ideas.size());

%>
<table>
<tr>
<td>title</td>
<td>description</td>
<td>view</td>
<td>apply</td>
</tr>
<%
if(ideas != null){
for(Idea idea : ideas){%>
	<tr>
	<td><% out.print(idea.getTitle()); %></td>
	<td><% out.print(idea.getDescription()); %></td>
	<td><a href="SearchIdeaController?method=<%="view" %>&title=<%=idea.getTitle() %>"/>view</td>
	<td><a href="SearchIdeaController?method=<%="apply" %>&title=<%=idea.getTitle() %>"/>Apply</td>
	</tr>
<%}
}%>
</table>

</body>
</html>