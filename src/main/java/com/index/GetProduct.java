package com.index;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetProduct {
  public static ResultSet getType()
  {
	  ResultSet rs=null;
	  try
      { 
         //Class.forName("com.mysql.jdbc.Driver");
		  Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=connection.getConn();
          Statement stmt = con.createStatement(); 
            
          // SELECT query 
          String q1 = "select distinct(type) from product.productlist "; 
           rs = stmt.executeQuery(q1);  
          /* while (rs.next()) 
           { 
               System.out.println("item_id : " + rs.getString(1)); 
             //  System.out.println("name :" + rs.getString(2)); 
               //System.out.println("type :" + rs.getString(3)); 
           }*/ 

  
	 //con.close(); 
     } 
  catch(Exception e) 
  { 
      System.out.println(e); 
  } 
	  return rs;

}
  /*public static void main(String[]args)
  {
	  GetProduct.getType();
  }*/
 
}