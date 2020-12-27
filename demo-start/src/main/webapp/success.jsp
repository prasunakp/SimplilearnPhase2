<%@page import="com.w.simplilearn.bean.UserData"%>
<%@page import="com.w.simplilearn.bean.ResponseData"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<body>
 <div align="center">
        <table border="1" cellpadding="5">
<caption><h2>List of Users</h2></caption>
<th>Name</th>
<th>Email</th>
<th>PhoneNumber</th>

<% ResponseData data = (ResponseData)session.getAttribute("attribute");
List<UserData> users = data.getUsers();
for(UserData user : users)
{
%>
<tr>
<td><%out.print(user.getName()); %></td>
<td><%out.print(user.getEmail()); %></td>
<td><%out.print(user.getPhonenumber()); %></td>
</tr>
<%} %>

</table>
</div>

</body>
</html>