package com.simplilearn.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet(name="login",urlPatterns={"/login"})
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	GetFlightDetailsFromDB flightDetails = new GetFlightDetailsFromDB();
	List<FlightModel> allFlights = flightDetails.getallFlights();
	String user = request.getParameter("name");
	String password = request.getParameter("password");
	AddCustomerDetailsInToDB userDetails = new AddCustomerDetailsInToDB();
	if(password==null && request.getParameter("changePassword")!=null)
	{
		request.getSession().setAttribute("changePassword", true);
		getServletContext().getRequestDispatcher("/adminlogin.jsp").forward(request, response);

	}
	else if(password!=null && request.getSession().getAttribute("changePassword")!=null)
	{
		AdminUser admin = userDetails.updatePassword(user, password);
		request.getSession().setAttribute("changePassword", null);
		getServletContext().getRequestDispatcher("/adminlogin.jsp").forward(request, response);
		admin.setPassword(password);
		
	}
	else if (request.getParameter("changePassword")==null)
	{
	AdminUser admin = userDetails.getAdmin(user);
	if(admin==null)
	{
	    request.getSession().setAttribute("errorMessage", null);
		userDetails.addadmin(user, password);
	}
	else if(!admin.getPassword().equals(password))
	{
	    request.getSession().setAttribute("errorMessage", null);
		request.getSession().setAttribute("errorMessage", "Please Enter correct password");
		getServletContext().getRequestDispatcher("/adminlogin.jsp").forward(request, response);
	}
	else
	{
    request.getSession().setAttribute("errorMessage", null);
	List<PlaceModel> allPlaces = flightDetails.getallPlaces();
	request.getSession().setAttribute("allflights", allFlights);
	request.getSession().setAttribute("allplaces", allPlaces);
	
	getServletContext().getRequestDispatcher("/flightsandplaces.jsp").forward(request, response);

	}	
	}
	}
}
