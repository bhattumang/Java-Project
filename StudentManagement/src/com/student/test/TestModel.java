package com.student.test;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.student.bean.UserBean;
import com.student.model.UserModel;

public class TestModel {
  public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
	 testAdd();
}
  
  private static void testAdd() throws ClassNotFoundException, SQLException, ParseException
  {
	  String fname="Aliya";
	  String lname="Bhatt";
	  String gender="F";
	  
	  String dateString="13/07/1998";
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/mmmmm/yyyy");
		java.util.Date dateUtil = null;
		try 
		  {
			dateUtil = sdf.parse(dateString);
		  } 
		  catch (ParseException e1) 
		  {
			e1.printStackTrace();
		  }

		Date dateSQL = new java.sql.Date(dateUtil.getTime());
	  
	  String state="Rajasthan";
	  String city="Banswara";
	  int pincode=327001;
	  String email="kalpana@gmail.com";
	   String number="7976668088";
	  String pass="123456";
	  
	  UserBean ub= new UserBean();
	  ub.setFname(fname);
	  ub.setLname(lname);
	  ub.setGender(gender);
	  ub.setDob(dateSQL);
	  ub.setState(state);
	  ub.setCity(city);
	  ub.setPincode (pincode);
	  ub.setEmail(email);
	  ub.setNumber(number);
	  ub.setPass(pass);
	 
	  UserModel Um= new UserModel();
	  Um.addUser(ub);
	
	  
  }
}
