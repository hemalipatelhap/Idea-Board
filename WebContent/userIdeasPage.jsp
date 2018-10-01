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
List<Idea> ideas = null;
if(request.getSession().getAttribute("netId") != null){
	String netId = request.getSession().getAttribute("netId").toString();
	IdeaDao  ideaDao = new IdeaDao();
	 ideas = ideaDao.getIdea(netId);

}
%>
<table>
<tr>
<td>title</td>
<td>description</td>
<td>view</td>
</tr>
<%
if(ideas != null){
for(Idea idea : ideas){%>
	<tr>
	<td><% out.print(idea.getTitle()); %></td>
	<td><% out.print(idea.getDescription()); %></td>
	<td>view</td>
	</tr>
<%}
}%>
</table>

</body>
</html>