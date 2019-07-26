package com.student.ctl;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.bean.UserBean;
import com.student.model.*;

@WebServlet(urlPatterns = { "/LoginCtl", "/login" })
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
{
		String ViewEmail = request.getParameter("email");
		String ViewPass = request.getParameter("pass");

		if (ViewEmail.equals("") || ViewPass.equals("")) 
		{
			request.setAttribute("error", "Please, Enter Value of Username and Password");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		}
		else {
			if (!(Pattern.matches("^(.+)@(.+)$", ViewEmail))) 
			{
				request.setAttribute("error", "Please, Enter Valid Pattern of Email ");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				rd.forward(request, response);
			}
			}

			String fname = null;
			String lname = null;
			String email = null;
			String pass = null;
			UserModel um = new UserModel();
			UserBean ub    = new UserBean();
			ub.setEmail(ViewEmail);
			ub.setPass(ViewPass);
	  
				try {
					ub = um.Authenticate(ub);
				} catch (Exception e) {
					e.printStackTrace();
				}
					fname = ub.getFname();
					lname = ub.getLname();
					email =  ub.getEmail();
					pass =   ub.getPass();
				//Cookie 
				Cookie c1 = new Cookie("userId", email);   // Set Two Cookie in Browser for Session Handling.
				c1.setMaxAge(24 * 60 * 60); // It set in Seconds.
				response.addCookie(c1);

				Cookie c2 = new Cookie("pass", pass);
				c2.setMaxAge(60 * 5);
				response.addCookie(c2);

				// ------------------------Cookie Code End and Session Start----------------
				HttpSession session = request.getSession(); // default false
				// Store Session information.
				// Date created=new Date(session.getCreationTime());
				// Date accessed=new Date(session.getLastAccessedTime());
				// String ID = session.getId();
				session.setAttribute("email", email);
				session.setAttribute("pass", pass);
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);

				ServletContext ctx = getServletContext();
				Integer count = (Integer) ctx.getAttribute("Visitcount");
				// response.setIntHeader("Refresh", 10);
				
				if (count == null) 
				{
					count = 1;
				}  
				else 
				{
					count++;
				}
				ctx.setAttribute("Visitcount", count);
				session.setAttribute("count", count);
				
				if(fname!=null)
				{
		     		request.setAttribute("fname", fname + "  " + lname);
			    	RequestDispatcher rd = request.getRequestDispatcher("WelcomeCtl.do");
				    rd.forward(request, response);
				}
				else
				{
					request.setAttribute("error", "Username and Password is Wrong");
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					rd.forward(request, response);
			   }					
	  }	 
}	
