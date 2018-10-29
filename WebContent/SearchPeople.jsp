<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ideaboard.dao.SkillDao,com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Skill,com.ideaboard.model.Idea,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%request.getSession().setAttribute("search", "people"); %>
<form method="post" action="SearchIdeaController">

<table>

<tr>

<td>First name:</td>

<td><input type="text" name="name" size="10" /></td>
</tr>
<tr>
<td><input type="submit" value="Search" /></td>

</tr>

</table>

</form>
</body>
</html>