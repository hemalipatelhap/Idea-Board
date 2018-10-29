<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ideaboard.dao.SkillDao,com.ideaboard.dao.IdeaDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Skill,com.ideaboard.model.Idea,com.ideaboard.model.UserProfile,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search idea page</title>
</head>
<body>
 <%request.getSession().setAttribute("search", "idea"); %>
<form method="post" action="SearchIdeaController">

<table>

<tr>

<td>Idea Title:</td>

<td><input type="text" name="ideatitle" size="10" /></td>
</tr>


<tr>
<%

SkillDao skillDao = new SkillDao();
List<Skill> skills = skillDao.get();%>
<td>Primary Skill:</td>

<td><select name="skill1">
 <%--
 <option value="java">java</option>--%>
 <option value="-1">-Select skill-</option>
<% 
for(Skill skill : skills){%>
	 <option value="<%out.print(skill.getName());%>"><%out.print(skill.getName());%></option>
 <%} %>


</select></td>
<td>Secondary Skill:</td>

<td><select name="skill2">
 <%--
 <option value="java">java</option>--%>
 <option value="-1">-Select skill-</option>
<% 
for(Skill skill : skills){%>
	 <option value="<%out.print(skill.getName());%>"><%out.print(skill.getName());%></option>
 <%} %>


</select></td>
</tr>
<tr>

<td><input type="submit" value="Search" /></td>

</tr>

</table>

</form>



</body>
</html>