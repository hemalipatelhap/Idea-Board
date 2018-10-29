<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ideaboard.dao.SkillDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Skill,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="IdeaController?method=<%="create" %>" method = "post">
<table>
<tr><td>Title</td><td><input type="text" name="title"/></td></tr>
<tr><td>Description</td><td><textarea name="description" rows="10" cols="30"></textarea></td></tr>
<tr>
<td>Skills</td>

<%
SkillDao skillDao = new SkillDao();
List<Skill> skills = skillDao.get();%>


<td>
<% 
 for(Skill skill : skills){%>
	 <p><input type="checkbox" name="skill" value="<%out.print(skill.getName());%>"/><%out.print(skill.getName());%></p>
 <%} %>

</td>

</tr>
<tr>
<td>Experience</td>
<td>
<input type = "radio" name="exp" value="1">less than 1 year
<input type = "radio" name="exp" value="2">1-2 years
<input type = "radio" name="exp" value="3">3-5 years
<input type = "radio" name="exp" value="4">more than 5 years
</td>
</tr>
<tr>
<td>Status</td>
<td>
<input type = "radio" name="status" value="0">Idea
<input type = "radio" name="status" value="1">Project
</td>
</tr>

<tr><td><input type="submit" value="post"/></td></tr>
</table>
</form>
</body>
</html>