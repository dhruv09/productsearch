<%@ page import = "java.util.Map" %>

<%@ page import ="java.util.List" %>

<%@ page import = "com.hib.UserDetails" %>

<%@ page import = "java.util.Iterator" %> 





<!DOCTYPE html>

<html lang="en">

<head> 

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>





 <body background="/img/background_airplane.jpg">



<!--  DEPARTURE DETAILS -->

<%

List<UserDetails> list = (List<UserDetails>) request.getSession().getAttribute("userDetails");
if(list.isEmpty()){

%>



	<!-- DEPARTURE DETAILS No Data Message   -->

	   <div class="card">

         <div class="card-body">

		   <div class="container-fluid">

		      <div class="card bg-success text-white">

          <div class="card-body"> <font size="6">No Data Available for Product </font></div>

        </div>

      <div> 

   

<% 	

}

else{

%>





<!-- DEPARTURE DETAILS HEADER  -->

     <div class="card">

         <div class="card-body">

		   <div class="container-fluid">

	        	<div class="card bg-success text-white">

                   <div class="card-body"> <font size="6">Product  Details </font></div>

                </div>

            <div>

	    <div>

<% 



Iterator<UserDetails> itr1 = list.iterator();

while(itr1.hasNext()){

	UserDetails userDetail = itr1.next();

%>

     <!-- Printing Product Detail Data -->

     <div class="card">

         <div class="card-body">

	       <!-- Destination Arrival Airport -->

		     <div class="container-fluid">

		        <div class="row">

                    <div   class="col-sm-6 bg-light ">Color   : </div>

                   <div   class="col-sm-6 bg-light">Size   :  </div>

                </div>

               <div class="row">

                   <div   class="col-sm-6 text-primary"><%=userDetail.getColor() %></div>

                  <div   class="col-sm-6 text-primary"><%=userDetail.getSize()%></div>

                </div>  

                    

              <!--Flight Number - Total Fare -->

               <div class="row"  >

                 <div   class="col-sm-6 bg-light "> Item Id :</div>

                 <div   class="col-sm-6 bg-light"> Parent Item Id :  </div>

               </div>

               <div class="row">

                  <div   class="col-sm-6 text-primary"><%=userDetail.getItemId() %></div>

                  <div   class="col-sm-6 text-primary"><%=userDetail.getParentItemId() %></div>

              </div>

  

            <!--Departure Time - Arrival Time -->

              <div class="row"  >

                <div   class="col-sm-6 bg-light "> Name :</div>

                <div   class="col-sm-6 bg-light"> Price :  </div>

              </div>

               <div class="row">

                 <div   class="col-sm-6 text-primary"><%=userDetail.getName() %></div>

                 <div   class="col-sm-6 text-primary"><%=userDetail.getSalePrice() %></div>

                </div>		
                
                
                
                
                 <!--New ADDED Number - Total Fare -->

               <div class="row"  >

                 <div   class="col-sm-6 bg-light "> Short Description   :</div>

                 <div   class="col-sm-6 bg-light">Long Description   :  </div>

               </div>

               <div class="row">

                  <div   class="col-sm-6 text-primary"><%=userDetail.getShortDescription() %></div>

                  <div   class="col-sm-6 text-primary"><%=userDetail.getLongDescription() %></div>

              </div> 

		 </div><!-- end class="Body" -->	
		 
		 
		 
		 
		  <!--New ADDED 2 Number - Total Fare -->

               <div class="row"  >

                 <div   class="col-sm-6 bg-light "> Brand Name   :</div>

                 <div   class="col-sm-6 bg-light">Available Online :  </div>

               </div>

               <div class="row">

                  <div   class="col-sm-6 text-primary"><%=userDetail.getBrandName() %></div>

                  <div   class="col-sm-6 text-primary"><%=userDetail.getAvailableOnline() %></div>

              </div> 

		 </div><!-- end class="Body" -->

      </ul>

   </ul>

  </div>		

</div><!-- card div end -->	

<%

  }

}

%>	 

			

  </body>	

  

</html>			 

