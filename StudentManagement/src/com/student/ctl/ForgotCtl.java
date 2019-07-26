package com.student.ctl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.UserBean;
import com.student.model.UserModel;

@WebServlet("/ForgotCtl")
public class ForgotCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotCtl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String email=request.getParameter("email");
		if(email.equals(""))
		{
			request.setAttribute("error","Please Enter Mail ID");
			RequestDispatcher rd=request.getRequestDispatcher("forgotView.jsp");		
			rd.forward(request,response);
		}
		
		UserBean ub = new UserBean();
		ub.setEmail(email);
		String pass ="";
		
		UserModel Um = new UserModel();
		
	
			try {
				pass=Um.forgot(ub);
				System.out.println(pass);
			
				if(pass!=null)
				{
					request.setAttribute("pass",pass);
					RequestDispatcher rd=request.getRequestDispatcher("PasswordView.jsp");		
					rd.forward(request,response);
				}
	
			} catch (SQLException e) {
				request.setAttribute("error","Please, Enter Valid Email ID");
				RequestDispatcher rd=request.getRequestDispatcher("forgotView.jsp");		
				rd.forward(request,response);
				e.printStackTrace();
			}
	  }
	}
