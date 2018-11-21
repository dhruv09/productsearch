package com.index;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.json.simple.parser.ParseException;

import com.hib.ItemDetails;
//import com.hib.UserDetails;
//import com.hib.main.Product;
import com.hib.UserDetails;


@WebServlet("/Index")

public class Index extends HttpServlet {
	 private static final long serialVersionUID = 1L; 
	 public Index(){
		 super();
	 }
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String pname=request.getParameter("iname");
		//int value=HashContent.keycheck(pname);
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(ItemDetails.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		 Query query = session.createQuery("select i.itemId from ItemDetails i where i.name= " + "'" + pname +"'");
		 List fetchedData = query.getResultList();
		 try
		 {
		 Long value =(long)fetchedData.get(0);
		// System.out.println(value);
		 session.getTransaction().commit();
		//System.out.println(value);
		
		 List<UserDetails>  userDetails	 =	ProductNameDetail.getProductJsonString(value);
		 //request.setAttribute("userDetails", userDetails);
		 request.getSession().setAttribute("userDetails", userDetails);
		
		 for(UserDetails user  : userDetails)
			 System.out.println("user : " + user);
		 
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/searchResult.jsp");
		 requestDispatcher.forward(request, response);
		 
				} catch (RuntimeException | ParseException  e) {
					
					e.printStackTrace();
				}
		
		//System.out.println("from index");
		//PrintWriter out=response.getWriter();
		//out.println(jsonresult);
		
		
	}

	
	
}
