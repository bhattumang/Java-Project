package com.student.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.student.bean.UserBean;
import com.student.util.*;

public class UserModel {

	public int nextPK() throws ClassNotFoundException, SQLException {
		Connection conn;
		conn = JdbcDataSource.getConnection();

		int nextPK = 0;
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM USERREG");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			nextPK = rs.getInt(1);
		}
		JdbcDataSource.closeConnection(conn, ps, rs);

		return nextPK + 1;
	}

	public void addUser(UserBean ub) throws ClassNotFoundException, SQLException {
		Connection conn;
		conn = JdbcDataSource.getConnection();

		conn.setAutoCommit(false); // optional for transaction Handling.
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USERREG VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, nextPK());
		ps.setString(2, ub.getFname());
		ps.setString(3, ub.getLname());
		ps.setString(4, ub.getGender());
		ps.setDate(5, ub.getDob());
		ps.setString(6, ub.getState());
		ps.setString(7, ub.getCity());
		ps.setInt(8, ub.getPincode());
		ps.setString(9, ub.getEmail());
		ps.setString(10, ub.getNumber());
		ps.setString(11, ub.getPass());

		int res = ps.executeUpdate();
		conn.commit(); // optional for transaction Handling

		System.out.println(res + " Row Inserted Successfull");

		JdbcDataSource.closeConnection(conn, ps);
	}

	public UserBean Authenticate(UserBean ub) throws Exception {
		Connection conn;
		String fname = null;
		String lname = null;
		String gender = null;
		Date date = null;
		String state = null;
		String city = null;
		int pincode = 0;
		String email = null;
		String mobial = null ;
		String pass = null;

		conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("Select * from USERREG WHERE EMAIL=? and pass=?");
		ps.setString(1, ub.getEmail());
		ps.setString(2, ub.getPass());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			fname = rs.getString(2);
			lname = rs.getString(3);
			gender = rs.getString(4);
			date = rs.getDate(5);
			state = rs.getString(6);
			city = rs.getString(7);
			pincode = rs.getInt(8);
			email = rs.getString(9);
			mobial = rs.getString(10);
			pass = rs.getString(11);
		}

		ub = new UserBean();
		
		ub.setFname(fname);
		ub.setLname(lname);
		ub.setGender(gender);
		ub.setDob(date);
		ub.setState(state);
		ub.setCity(city);
		ub.setPincode(pincode);
		ub.setEmail(email);
		ub.setNumber(mobial);
		ub.setPass(pass);
		JdbcDataSource.closeConnection(conn, ps);
		return ub;

	}

	public String forgot(UserBean ub) throws SQLException {
		Connection conn;
		String pass;
		conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("Select PASS from USERREG WHERE EMAIL=?");
		ps.setString(1, ub.getEmail());
		ResultSet rs = ps.executeQuery();
		rs.next();
		pass = rs.getString(1);

		JdbcDataSource.closeConnection(conn, ps, rs);
		return pass;
	}

}
