package com.student.ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.*;
import com.student.model.*;

@WebServlet(urlPatterns = { "/RegUserCtl", "/reguser" })
public class RegUserCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegUserCtl() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String date = request.getParameter("dob");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String gender=request.getParameter("gender");
		String state=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String city=request.getParameter("city");
		String number=request.getParameter("number");
		
		if( email.equals("") || pass.equals(""))
		{
			request.setAttribute("error","Please, Enter Value of Username and Password");
			RequestDispatcher rd=request.getRequestDispatcher("RegView.jsp");		
			rd.forward(request,response);
		}
			if(!(Pattern.matches("^(.+)@(.+)$", email)))
			{
				request.setAttribute("error","Please, Enter Valid Pattern of Email ");
				RequestDispatcher rd=request.getRequestDispatcher("RegView.jsp");		
				rd.forward(request,response);
			}
		
		if(fname.equals("") || request.getParameter("lname").equals("") ||request.getParameter("state").equals(""))
		{
			request.setAttribute("error","Please fill the all Information");
			RequestDispatcher rd=request.getRequestDispatcher("RegView.jsp");		
			rd.forward(request,response);
			
		}
		UserBean ub = new UserBean();
		
		ub.setFname(fname);
		ub.setLname(lname);
		ub.setGender(gender);
		
        //------------------------Convert String Date to Until Date And Then SQL Date.---------------------------------		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mmmmm/yyyy");
		Date dateUtil = null;
		try 
		  {
			dateUtil = sdf.parse(date);
		  } 
		  catch (ParseException e1) 
		  {
			  request.setAttribute("error","Registration Failed");
				RequestDispatcher rd=request.getRequestDispatcher("RegView.jsp");		
				rd.forward(request,response);
		  }

		java.sql.Date dateSQL = new java.sql.Date(dateUtil.getTime());
		ub.setDob(dateSQL);
		
		//-------------------------------------------------End of Date Conversion-------------------------------------------------------
		
		ub.setState(state);
		ub.setCity(city);
		ub.setPincode (pincode);
		ub.setEmail(email);
		ub.setNumber(number);
		ub.setPass(pass);
		

		UserModel Um = new UserModel();
		try {
			Um.addUser(ub);
			request.setAttribute("success","Registration Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("LoginView.jsp");		
			rd.forward(request,response);	

		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("error","Registration Failed");
			RequestDispatcher rd=request.getRequestDispatcher("RegView.jsp");		
			rd.forward(request,response);
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
