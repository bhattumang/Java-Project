package com.student.util;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {
     //JDBC datasource object 
	 private static JdbcDataSource jds=null;
	 
	 //C3P0 database connection pool Add this Jar File
	 private ComboPooledDataSource ds= null;
	 
	 String Driver="com.mysql.jdbc.Driver";
	 String JdbcUrl= "jdbc:mysql://localhost:3306/Registration";
	 private JdbcDataSource(){
	   try{
		   ds=new ComboPooledDataSource();
		   ds.setDriverClass(Driver);
		   ds.setJdbcUrl(JdbcUrl);
		   ds.setUser("root");
		   ds.setPassword("root");
		   ds.setInitialPoolSize(3);
		   ds.setAcquireIncrement(3);
		   ds.setMaxPoolSize(50);
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	 }
	 //get singleton class instance
	 public static JdbcDataSource getInstance(){
		 if(jds == null) {
			 jds = new JdbcDataSource();
		 }
		 return jds;
	 }
	 
	 //get Connection from DCP
	 public static Connection getConnection(){
		 try{
			 return getInstance().ds.getConnection();
			 
		 }catch (SQLException e){
			return null;
		 }
	 }
	 
	 //Close Connection
	 public static void closeConnection(Connection conn,Statement stmt,ResultSet rs)
	 {
		  try{
			  if(rs !=null) rs.close();
			  if(stmt !=null) stmt.close();
			  if(conn!=null) conn.close();
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	 }
	 
	 
	 public static void closeConnection(Connection conn,Statement stmt)
	 {
		  closeConnection(conn, stmt,null);
	 }
	 
	 public static void closeConnection(Connection conn)
	 {
		  closeConnection(conn, null,null);
	 }
}
