package com.ideaboard.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private static Connection con;
	 public static Connection getConnection(){  
	        if(con != null) return con;
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lasya123"); 
	            System.out.println("connected");
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	        }
	        
	    
}
