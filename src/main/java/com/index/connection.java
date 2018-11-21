package com.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	static public Connection getConn() throws SQLException
	{ 
		 Connection con=null;
		
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "dhruv135"); 
		
		 return (con);
	}

}
