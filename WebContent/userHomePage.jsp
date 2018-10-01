<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome, 
<%
 if(request.getSession().getAttribute("username")!=null)
           {
                 out.println(request.getSession().getAttribute("username"));
                 out.println(request.getSession().getAttribute("netId"));
                
           }
%>
</h1>
<ul>
<li><a href="viewProfile.jsp">view profile</a></li>
<li><a href="createIdea.jsp">create</a></li>
<li><a href="userIdeasPage.jsp">my ideas</a></li>
</ul>
</body>
</html>