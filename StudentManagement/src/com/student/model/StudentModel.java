package com.student.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.student.bean.StudentBean;
import com.student.util.JdbcDataSource;

public class StudentModel {

	public int nextPK() throws ClassNotFoundException, SQLException {
		Connection conn;
		conn = JdbcDataSource.getConnection();

		int nextPK = 0;
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(ROLLNO) FROM StudentData");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			nextPK = rs.getInt(1);
		}
		JdbcDataSource.closeConnection(conn, ps, rs);

		return nextPK + 1;
	}

	public void addStudent(StudentBean sb) throws ClassNotFoundException, SQLException {
		Connection conn;
		conn = JdbcDataSource.getConnection();

		conn.setAutoCommit(false); // optional for transaction Handling.
		PreparedStatement ps = conn.prepareStatement("INSERT INTO StudentData VALUES(?,?,?,?)");
		int rollno = nextPK();
		ps.setInt(1, rollno);
		ps.setString(2, sb.getFname());
		ps.setString(3, sb.getLname());
		ps.setString(4, sb.getSession());

		ps.executeUpdate();
		conn.commit(); // optional for transaction Handling
		JdbcDataSource.closeConnection(conn, ps);
	}

	public int update(StudentBean sb) throws ClassNotFoundException, SQLException {
		Connection conn;
		conn = JdbcDataSource.getConnection();
        int res=0;
		PreparedStatement ps = conn.prepareStatement("UPDATE StudentData SET fname=?,lname=?,session=? where rollNo=?");

		ps.setString(1, sb.getFname());
		ps.setString(2, sb.getLname());
		ps.setString(3, sb.getSession());
        ps.setInt(4, sb.getRollNo());
		res = ps.executeUpdate();
		JdbcDataSource.closeConnection(conn, ps);
		return res;
	}

	public int delete(StudentBean sb) throws ClassNotFoundException, SQLException {
		Connection conn;
		conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("DELETE FROM StudentData WHERE RollNO=?");
		ps.setInt(1, sb.getRollNo());
		int res = ps.executeUpdate();
		JdbcDataSource.closeConnection(conn, ps);
		return res;
	}
	
	public ArrayList<StudentBean> getData() throws ClassNotFoundException, SQLException {
		Connection conn;
		conn=JdbcDataSource.getConnection();
		ArrayList<StudentBean> al=new ArrayList<StudentBean>();
		
		PreparedStatement ps = conn.prepareStatement("Select Rollno, Fname, Lname, Session from StudentData limit 2,5");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			StudentBean sb=new StudentBean();
			sb.setRollNo(rs.getInt(1));
			sb.setFname(rs.getString(2));
			sb.setLname(rs.getString(3));
			sb.setSession(rs.getString(4));
	        al.add(sb);			
		}
		JdbcDataSource.closeConnection(conn,ps);
		return al;
	}
	
   public StudentBean search(StudentBean sb1) throws ClassNotFoundException, SQLException {
		Connection conn;
		conn=JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("Select * From StudentData where rollno=?");
		ps.setInt(1, sb1.getRollNo());
		ResultSet rs = ps.executeQuery();
		sb1=new StudentBean();
		while (rs.next()) {
			sb1.setRollNo(rs.getInt(1));
			sb1.setFname(rs.getString(2));
			sb1.setLname(rs.getString(3));
			sb1.setSession(rs.getString(4));
		}
		JdbcDataSource.closeConnection(conn,ps);
		return sb1;
	}
}
