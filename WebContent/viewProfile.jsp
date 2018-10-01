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

<%
UserProfile profile=null;
if(request.getSession().getAttribute("netId") != null){
UserDao userDao = new UserDao();
profile = userDao.getProfile(request.getSession().getAttribute("netId").toString());
}
%>
<form action="UpdateProfileController" method= "post">
<table>
<tr>
<td>
My Skills

<% 
if(profile != null){
 for(String skill : profile.getSkills()){%>
	 <%out.print(skill+",");%>
 <%}} %>

</td>

</tr>
<tr>
<td>
Add Skills
</td>
</tr>
<tr>
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
<td>
My Areas Of Interest

<% 
if(profile != null){
 for(String aoi : profile.getAoiList()){%>
	 <p><%out.print(aoi+",");%></p>
 <%}} %>
</td>

</tr>
<tr>
<td>
Add Areas Of Interest
</td>
</tr>
<tr>

<%
AreaOfInterestDao aoiDao = new AreaOfInterestDao();
List<AreaOfInterest> aoiList = aoiDao.get();%>

<td>
<% 
 for(AreaOfInterest aoi : aoiList){%>
	 <p><input type="checkbox" name="aoi" value="<%out.print(aoi.getName());%>"/><%out.print(aoi.getName());%></p>
 <%} %>

</td>





</tr>
<tr>
<td>My Experience <%

	out.print(profile.getExperience());

 %> </td>
</tr>
<tr>
<td>
<input type = "radio" name="exp" value="1">less than 1 year<br>
<input type = "radio" name="exp" value="2">1-2 years<br>
<input type = "radio" name="exp" value="3">3-5 years<br>
<input type = "radio" name="exp" value="4">more than 5 years<br>
</td>
</tr>
<tr><td><input type="submit" value="update"/></td></tr>
</table>
</form>
</body>
</html>