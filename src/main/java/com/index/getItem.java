package com.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/getItem")
public class getItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getItem() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Connection con=null;
		 ResultSet rs=null;
		 List list = new LinkedList();
		 
			
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "dhruv135");
			Statement stmt = con.createStatement(); 
           
	          // SELECT query 
	          String q1 = "select name,type from product.productlist "; 
	           rs = stmt.executeQuery(q1);  
	           
	          
	           
		          String t="[";
		           

		           while( rs.next() ){
		        	   String name = rs.getString(1);
		        	   String type = rs.getString(2);
		        	   //list.add(name);
		        	  // map.put(name, type);
		        	   
		        	   t+="{\"type\":\""+type+"\",\"name\":\""+name+"\"},";
		        	    
		        	  
		           }
		       //    t+="]";	     
		           
		           String newString = t.substring(0,t.length()-1);
		           newString += "]";
		            System.out.println("New String : " + newString) ;
	           System.out.println("List : " + list);
	           Gson gson = new Gson();
	          String jsonString = gson.toJson(newString);
	          PrintWriter out=response.getWriter();
	            out.println(newString);
	
	            
	           	} catch (Exception e) {
		  System.out.println(e);
		} 
		
	}
	
	public static void main(String ars[])
	{
		Object o;
		
		Connection con=null;
		 ResultSet rs=null;
		 List list = new LinkedList();
		 Map map = new HashMap();
		 
			
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "dhruv135");
			Statement stmt = con.createStatement(); 
           
	          // SELECT query 
	          String q1 = "select name,type from product.productlist "; 
	           rs = stmt.executeQuery(q1);  
	           
	          String t="[";
	           

	           while( rs.next() ){
	        	   String name = rs.getString(1);
	        	   String type = rs.getString(2);
	        	   //list.add(name);
	        	   map.put(name, type);
	        	   
	        	   t+="{'type':'"+type+"','name':'"+name+"'},";
	        	    
	        	  
	           }
	           t+="]";
	           
	           System.out.println("string: "+t);
	          System.out.println("List : " + list);
	           Gson gson = new Gson();
	          String jsonString = gson.toJson(map);
	          System.out.println("JsonString " + jsonString);
	         // PrintWriter out=response.getWriter();
	           //out.println("ResultSet json string : "+jsonString);
	
	            
	           	} catch (Exception e) {
		  System.out.println(e);
		} 
	
	}

	
	

}
