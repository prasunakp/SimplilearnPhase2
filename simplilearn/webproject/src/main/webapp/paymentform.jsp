<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.simplilearn.register.FlightModel"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%FlightModel flight = (FlightModel) session.getAttribute("paymentFlight"); %>
 <%String price = (String) session.getAttribute("flightPrice"); %>
<p>Flight Number :<%out.print(flight.getFlightNumber()); %></p>
<p>Flight Name: <%out.print(flight.getFlightName()); %></p>
<p>Price : <%out.print(price);%></p>
<p>From :<%out.print(flight.getSource()); %></p>
<p>To: <%out.print(flight.getDestination()); %></p>

<form action="/webproject/customerRegistrationAndPayment" method = "GET">
<p>Credit Card Number: <input type="text" id="number" name = "number"></p>
<p>Name : <input type="text"  id="name" name = "name"> </p>
<p>ExpDate And ExpYear : <input type="text"  id="exp" name = "exp"></p>
<p>CVV : <input type="text"  id="cvv" name = "cvv"></p>
 
     <input type="submit" value="submit">            
 </form>
</body>
</html>