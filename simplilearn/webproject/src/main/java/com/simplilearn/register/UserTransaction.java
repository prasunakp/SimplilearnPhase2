package com.simplilearn.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserTransaction
 */

@WebServlet(name="userTransaction",urlPatterns={"/getFlightDetails"})
public class UserTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Integer source =   Integer.valueOf(request.getParameter("flightNumber1"));
	    GetFlightDetailsFromDB getFlightDetails = new GetFlightDetailsFromDB();
	   FlightModel flightSelected =  getFlightDetails.getFlightById(source.intValue());
	   System.out.println("flight NUmberrrr "+flightSelected.getFlightNumber());
	    request.getSession().setAttribute("flightselected", flightSelected.getFlightNumber().toString());
	    request.getSession().setAttribute("flightPrice", request.getParameter("price"));

	    getServletContext().getRequestDispatcher("/customerform.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String source = request.getParameter("source");
	 String date =   request.getParameter("requestedDate");
	 String noOfPersons =   request.getParameter("noOfPersons");
	    String destination = request.getParameter("destination");
	    GetFlightDetailsFromDB getFlightDetails = new GetFlightDetailsFromDB();
	  List<FlightModel> flights =   getFlightDetails.getFlights(source, destination);
	    request.getSession().setAttribute("listOfFlights", flights);
	    request.getSession().setAttribute("requestedDate", date);
	    request.getSession().setAttribute("noOfPersons", noOfPersons);

	    getServletContext().getRequestDispatcher("/displayFlightDetails.jsp").forward(request, response);
	}

}
