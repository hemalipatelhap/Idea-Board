<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TaskController?method=<%="create" %>&projectId=<%out.print(request.getAttribute("projectId").toString()); %>" method = "post">
<table>
<tr><td>Name</td><td><input type="text" name="name"/></td></tr>
<tr>
<td>Status</td>
<td>
<input type = "radio" name="status" value="1">started
<input type = "radio" name="status" value="2">in progress
<input type = "radio" name="status" value="3">complete
</td>
</tr>
<tr>
<td>Priority</td>
<td>
<input type = "radio" name="priority" value="1">1
<input type = "radio" name="priority" value="2">2
<input type = "radio" name="priority" value="3">3
<input type = "radio" name="priority" value="4">4
<input type = "radio" name="priority" value="5">5
</td>
</tr>

<tr><td><input type="submit" value="create"/></td></tr>
</table>
</form>
</body>
</html>