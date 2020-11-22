package com.simplilearn.register;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerRegistrationAndPayment
 */
@WebServlet(name="customerRegistrationAndPayment",urlPatterns={"/customerRegistrationAndPayment"})
public class CustomerRegistrationAndPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationAndPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel user = (UserModel)request.getSession().getAttribute("currentUser");
		InsertOrderInToDB insertOrder = new InsertOrderInToDB();
OrderModel order = insertOrder.insertOrder(user.getEmail(), user.getFlightNumber(), (String)request.getSession().getAttribute("flightPrice"));
request.getSession().setAttribute("order", order);
		getServletContext().getRequestDispatcher("/orderconfirmation.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int flightNumber = Integer.valueOf(request.getParameter("userflight"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		AddCustomerDetailsInToDB addcustomer = new AddCustomerDetailsInToDB();
		UserModel user = addcustomer.addcustomer(email, Integer.valueOf(phone), name, String.valueOf(flightNumber));
		GetFlightDetailsFromDB searchById = new GetFlightDetailsFromDB();
	FlightModel flightAtPayment =	searchById.getFlightById(flightNumber);
	request.getSession().setAttribute("paymentFlight",flightAtPayment );
	request.getSession().setAttribute("currentUser",user );

getServletContext().getRequestDispatcher("/paymentform.jsp").forward(request, response);
	}

}
