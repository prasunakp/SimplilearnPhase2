<%@page import="com.simplilearn.register.OrderModel"%>
<%@page import="com.simplilearn.register.FlightModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Thanks for your Order</h2>

 <%FlightModel flight = (FlightModel) session.getAttribute("paymentFlight"); %>
  <%OrderModel order = (OrderModel) session.getAttribute("order"); %>
<p>Order : <%out.print(order.getOrderNumber()); %></p> 
<p>Email : <%out.print(order.getUser()); %></p> 
<p>Price : <%out.print(order.getPrice()); %></p> 
<p>Flight : <%out.print(flight.getFlightName()); %> Flightnumber : <%out.print(flight.getFlightNumber()); %> </p> 
</body>
</html>