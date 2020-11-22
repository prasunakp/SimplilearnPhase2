<%@page import="com.simplilearn.register.PlaceModel"%>
<%@page import="java.util.List"%>
<%@page import="com.simplilearn.register.FlightModel"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <div align="center">


        <table border="1" cellpadding="5">
            <caption><h2>List of Flights</h2></caption>
<tr>
                <th>ID</th>
                <th>Name</th>
                <th>Source</th>
                <th>Destination</th>
 <th>Price</th>

            </tr>
 <%
            List<FlightModel> listOfFlights =(List<FlightModel>)session.getAttribute("allflights");
            for(FlightModel flight : listOfFlights)
            { %>
                <tr>
                    <td><%out.print(flight.getFlightNumber()); %></td>
                    <td><%out.print(flight.getFlightName()); %></td>
                    <td><%out.print(flight.getSource()); %></td>
                    <td><%out.print(flight.getDestination());%></td>   
                    <td><%out.print(flight.getPrice());%></td>   

                </tr>
       
  <% }%>
   </table>
          <table border="1" cellpadding="5">
            <caption><h2>List of Source and Destination</h2></caption>
            <tr>
                <th>Source</th>
                <th>Destination</th>
            </tr>
 <%
            List<PlaceModel> places =(List<PlaceModel>)session.getAttribute("allplaces");
            for(PlaceModel place : places)
            { %>
                <tr>
                    <td><%out.print(place.getSource()); %></td>
                    <td><%out.print(place.getDestination());%></td>   
                </tr>
       
  <% }%>
   </table>
  <table border="1" cellpadding="5">
            <caption><h2>List of AirLines</h2></caption>
<tr>
               
                <th>Name</th>

            </tr>
 <%
            List<FlightModel> airLines = (List<FlightModel>)session.getAttribute("allflights");
            for(FlightModel flight : listOfFlights)
            { %>
                <tr>
                  
                    <td><%out.print(flight.getFlightName()); %></td>
              

                </tr>
       
  <% }%>
   </table>
    </div>

           
