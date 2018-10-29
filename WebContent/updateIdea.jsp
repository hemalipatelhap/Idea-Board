<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%@page import="com.ideaboard.dao.IdeaDao,com.ideaboard.dao.SkillDao,com.ideaboard.dao.AreaOfInterestDao,com.ideaboard.dao.UserDao,com.ideaboard.model.Idea,com.ideaboard.model.IdeaDetails,com.ideaboard.model.UserProfile,com.ideaboard.model.Skill,com.ideaboard.model.AreaOfInterest,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Idea idea = null;
IdeaDetails details = null;
int experience = 0;
int status = 0;
if(request.getAttribute("idea") != null && request.getAttribute("details") != null ){
	  idea = (Idea) request.getAttribute("idea");
	  details = (IdeaDetails) request.getAttribute("details");
	  
	  
	}%>
<form action="IdeaController?method=<%="update"%>&oldTitle=<%=idea.getTitle()%>" method = "post">
<table>
<tr><td>Title</td><td><input type="text" name="title" value="<%out.print(idea.getTitle());%>"></td></tr>
<tr><td>Description</td><td><textarea name="description" rows="10" cols="30"> <%out.print(idea.getDescription());%></textarea></td></tr>
<tr>
<td>Skills</td>

<%
SkillDao skillDao = new SkillDao();
List<Skill> skills = skillDao.get();%>


<td>
<% 
 for(Skill skill : skills){%>
     <%if(details.getSkills().contains(skill.getName())){ %>
	 <p><input type="checkbox" name="skill" value="<%out.print(skill.getName());%>" checked="checked"/><%out.print(skill.getName());%></p>
	 <%} else{ %>
	 <p><input type="checkbox" name="skill" value="<%out.print(skill.getName());%>"/><%out.print(skill.getName());%></p>
	 <%} %>
 <%} %>

</td>

</tr>
<tr>
<td>Experience</td>
<td>
<input type = "radio" name="exp" value="1" ${details.getExperienceVal() == 1 ? 'checked' : '' } />less than 1 year
<input type = "radio" name="exp" value="2" ${details.getExperienceVal() == 2 ? 'checked' : '' }/>1-2 years
<input type = "radio" name="exp" value="3" ${details.getExperienceVal() == 3 ? 'checked' : '' }/>3-5 years
<input type = "radio" name="exp" value="4" ${details.getExperienceVal() == 4 ? 'checked' : '' }/>more than 5 years
</td>
</tr>
<tr>
<td>Status</td>
<td>
<input type = "radio" name="status" value="0" ${idea.getStatus() == 0 ? 'checked' : '' } />Idea
<input type = "radio" name="status" value="1" ${idea.getStatus() ==1? 'checked' : ''}/>Project
</td>
</tr>

<tr><td><input type="submit" value="update"/></td></tr>
</table>
</form>
</body>
</html>