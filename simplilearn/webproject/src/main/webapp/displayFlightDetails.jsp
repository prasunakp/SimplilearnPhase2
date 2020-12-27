
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.register.FlightModel"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Flights</h2></caption>
<tr>
               <th>Date</th>
                <th>ID</th>
                <th>Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Price</th>
                 <th>Select</th>
            </tr>
 <%
            List<FlightModel> listOfFlights =(List<FlightModel>)session.getAttribute("listOfFlights");
            for(FlightModel flight : listOfFlights)
            {
            
            String a=	(String) session.getAttribute("noOfPersons");
           int price = flight.getPrice()*Integer.valueOf(a);
         String date =  (String) session.getAttribute("requestedDate");
            %>
            
                <tr>
                    <td><%out.print(date); %></td>
                    <td><%out.print(flight.getFlightNumber()); %></td>
                    <td><%out.print(flight.getFlightName()); %></td>
                    <td><%out.print(flight.getSource()); %></td>
                    <td><%out.print(flight.getDestination());%></td>
                    <td><%out.print(price);%></td>

<form action="/webproject/getFlightDetails" method = "GET">
<input type = "hidden" value = '<%out.print(price);%>' name = "price" id = "flightNumber1" >	
            <input type = "hidden" value = '<%out.print(flight.getFlightNumber());%>' name = "flightNumber1" id = "flightNumber1" >	
          <td > <input type="submit"  name="submit">  </td>
            </form>    
                </tr>
       
  <% }%>
   </table>
    </div>

           
