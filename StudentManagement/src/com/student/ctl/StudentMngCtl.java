package com.student.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.StudentBean;
import com.student.model.StudentModel;

@WebServlet("/StudentMngCtl.do")
public class StudentMngCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentMngCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentBean sb = new StudentBean();
		String temp = request.getParameter("rollno");
		if (temp.equals("")) {
			sb.setRollNo(0);
		} else
			sb.setRollNo(Integer.parseInt(temp));
		sb.setFname(request.getParameter("fname"));
		sb.setLname(request.getParameter("lname"));
		sb.setSession(request.getParameter("session"));

		String op = request.getParameter("operation");
		StudentModel sm = new StudentModel();

		if (op.equals("Add")) {
			sm = new StudentModel();
			try {
				sm.addStudent(sb);
					request.setAttribute("success", "Student Registered");
					RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
					rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("error", "Student Registration Failed");
				RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
				rd.forward(request, response);
			}

		}

		if (op.equals("Update")) {
			int res = 0;
			try {
				res = sm.update(sb);
				if (res != 0) {
					request.setAttribute("success", "Update Successfully " + res);
					RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (op.equals("Delete")) {
			int res = 0;
			try {
				res = sm.delete(sb);
				if (res != 0) {
					request.setAttribute("success", "Delete Successfully");
					RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (op.equals("Get")) {

			ArrayList<StudentBean> al = new ArrayList<StudentBean>();
			try {
				al = sm.getData();
				if (al != null) {
					request.setAttribute("al", al);
					RequestDispatcher rd = request.getRequestDispatcher("StudDataView.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("error", "Data Is Null");
				RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
				rd.forward(request, response);
			}
		}
		if (op.equals("Search")) {
				PrintWriter out = response.getWriter();
				out.println("demo");
				try {
					StudentBean sb1 = sm.search(sb);
					int rollno = sb1.getRollNo();
					String fname = sb1.getFname();
					String lname = sb1.getLname();
					String session = sb1.getSession();
					request.setAttribute("success", " " + rollno + " " + fname + " " + lname + " " + session);
					RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
					rd.forward(request, response);

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	
}
