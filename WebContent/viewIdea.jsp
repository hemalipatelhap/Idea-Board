<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Idea,com.ideaboard.model.IdeaDetails,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script language="javascript"> 
<% String from = "view";
from=request.getAttribute("from").toString();%>
window.onload = function(){ 
   var from ="<%=from%>"; 
   
   if(from == "search"){
       document.getElementById("edit").style.display = "none";
   }
  
} 

</script>
<body>
<%
Idea idea = null;
IdeaDetails details = null;
if(request.getAttribute("idea") != null){
	  idea = (Idea) request.getAttribute("idea");
	  details = idea.getIdeaDetails();
	}%>
<table>
<tr>
<td>
title : <% out.print(idea.getTitle()); %>
</td>
</tr>
<tr>
<td>
description : <% out.print(idea.getDescription()); %>
</td>
</tr>
<tr>
<td>
Skills :
 <% 
if(details != null && details.getSkills() != null){
for(String skill : details.getSkills()){%>
	<% out.print(skill);%>
<% }
}%>

</td>
</tr>
<tr>
<td>
Experience : <% 
if(details != null && details.getExperience()!= null){%>
<%out.print(details.getExperience()); %>
	<% }%>

</td>
</tr>
<tr>
<td>
<div id="edit">
<a href="IdeaController?method=<%="update"%>&title=<%=idea.getTitle()%>"/>edit
</div>


</td>
</tr>
</table>
</body>

</html>