<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Form</h1>
<p>
<%
 if(request.getAttribute("registrationSuccessMsg")!=null)
           {
                 out.println(request.getAttribute("registrationSuccessMsg")); //get record insert success message from AddController.java
           }
                %>
</p>
<form action="RegistrationController" method = "post">
<table>
<tr><td>Netid</td><td><input type="text" name="netId"/></td></tr>
<tr><td>First Name</td><td><input type="text" name="fname"/></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lname"/></td></tr>
<tr><td>Username</td><td><input type="text" name="username"/></td></tr>
<tr><td>Password</td><td><input type="password" name="password"/></td></tr>
<tr><td><input type="submit" value="register"/></td></tr>
</table>
</form>
</body>
</html>