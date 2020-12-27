<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("errorMessage")!=null){ %>
<font color="red"><%out.print(session.getAttribute("errorMessage"));%></font>
<%} %>

<%if(session.getAttribute("changePassword")==null){ %>
<form action="/webproject/login" method="post">  
Name:<input type="text" name="name"/><br/><br/>  
Password:<input type="password" name="password"/><br/><br/>  
<input type="submit" value="login"/>"  
</form>  
<%} %>


<%if(session.getAttribute("changePassword")!=null){ %>
<form action="/webproject/login" method="post">  
Name:<input type="text" name="name"/><br/><br/>  
New Password:<input type="password" name="password"/><br/><br/>  
<input type="submit" value="login"/>"  
</form>  
<%} %>

<form name="submitForm" method="POST" action="/webproject/login">
    <input type="hidden" name="changePassword" value="true">
    <A HREF="javascript:document.submitForm.submit()">Change Password</A>
</form>
</body>
</html>