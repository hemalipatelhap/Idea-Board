package com.ideaboard.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private static Connection con;
	 public static Connection getConnection(){  
	        if(con != null) return con;
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ideaboard","root","password"); 
	            System.out.println("connected");
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	        }
	        
	    
}