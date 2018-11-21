package com.index;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
//import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hib.UserDetails;
import com.hib.main.Product;

public class ProductNameDetail {
private static final String apiKey="hyhwj88ed5huh5tjteb4uxx2";
private static final String baseUrl="http://api.walmartlabs.com";

static String setRequest(long value)
{
	   String baseproductUrl="";
	   String str="/v1/items/"+value+"?apiKey="+apiKey+"&format=json";
	    baseproductUrl=baseUrl+str;
	    return(baseproductUrl);
}


static String getResponse(String baseproductUrl)
{
String inline = "";
	
    try
    {
	URL url = new URL( baseproductUrl);
	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	conn.setRequestMethod("GET");
	conn.connect();
	int responsecode = conn.getResponseCode();
	System.out.println("Response code is: " +responsecode);
	    if(responsecode != 200)
		          throw new RuntimeException("HttpResponseCode: " +responsecode);
	    else
	       {
		    Scanner sc = new Scanner(url.openStream());
	        while(sc.hasNext())
	        {
		      inline+=sc.nextLine();
	        }
	        sc.close();
           }
	    conn.disconnect();
	    
    }
	    catch(Exception e)
		{
			e.printStackTrace();
		}
    
    return(inline);
}

static UserDetails parser(String inline) throws ParseException
{
	UserDetails ud = null;
		JSONParser parseobj = new JSONParser();
	    JSONObject jobj = (JSONObject)parseobj.parse(inline);
	    long itemId = (long) jobj.get("itemId");
	    long parentItemId=(long) jobj.get("parentItemId");
	    String name=(String) jobj.get("name");
	    double salePrice=(double) jobj.get("salePrice");
	    String shortDescription=(String) jobj.get("shortDescription");
	    String longDescription=(String) jobj.get("longDescription");
	    String brandName=(String) jobj.get("brandName");
	    Boolean availableOnline=(Boolean) jobj.get("availableOnline");
	    //System.out.println(itemId);
	   // System.out.println(str1);
	    JSONObject structure = (JSONObject) jobj.get("attributes");
	    String color=(String) structure.get("color");
	    String size=(String) structure.get("size");
	    ud=new UserDetails(itemId,parentItemId,name,salePrice,shortDescription,longDescription,brandName,availableOnline,color,size);
	    return (ud);
}
	

public static List<UserDetails> getProductJsonString(long value) throws RuntimeException, ParseException
{
	String baseproductUrl=setRequest(value);
	
	String inline=getResponse(baseproductUrl);
	
	  UserDetails ud = parser(inline);
	    if(ud==null)
	    	throw new RuntimeException();
	    Transaction tx = null;
		
		//SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		//SessionFactory sf = new Configuration().configure().addAnnotatedClass(UserDetails.class).buildSessionFactory();
	
	    
	    SessionFactory sf=Product.getConn();
	    System.out.println("Cfg and hbm files loaded succesfully");
        Session session = sf.openSession();
        tx=session.beginTransaction();
        //session.save(ud);
        Query query = session.createQuery("from UserDetails u where u.itemId="+"'"+value+"'" );
		 List<UserDetails> Data = query.getResultList();
		 
		 
		 System.out.println("# of rows: "+ Data.size());
		 System.out.println(Data.get(0));
        System.out.println("Transaction began");
     //   tx.commit();
        session.close();
        
        return Data;
	   
	}
   
   
}
  


