<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ideaboard.dao.IdeaDao,
com.ideaboard.dao.AreaOfInterestDao,
com.ideaboard.dao.UserDao,
com.ideaboard.dao.RequestDao,
com.ideaboard.model.Idea,
com.ideaboard.model.Request,
com.ideaboard.model.UserProfile,
com.ideaboard.model.AreaOfInterest,
java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Request> requests = null;
if(request.getAttribute("requests") != null){
	
	requests = (List<Request>) request.getAttribute("requests");

}
%>

<table>
<tr>
<td>Idea ID</td>
<td>Idea title</td>
<td>Net Id</td>
<td>Status</td>
</tr>
<%
if(requests != null){
for(Request request1 : requests){%>
	<tr>
	<td><% out.print(request1.getIdeaId()); %></td>
	<td>title here</td>
	<td><a href="UpdateProfileController?netId=<%= request1.getNetId() %>"><% out.print(request1.getNetId()); %></a></td>
	<td><% out.print(request1.getStatus()); %></td>
	<td><a href="RequestController?method=approve&requestId=<%= request1.getRequestId() %>&ideaId=<%= request1.getIdeaId() %>">Approve</a> / <a href="RequestController?method=decline&requestId=<%= request1.getRequestId()  %>&ideaId=<%= request1.getIdeaId() %>">Decline</a></td>
	</tr>
<%}
}%>
</table>
</body>
</html>