
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.index.connection,java.sql.*,com.index.GetProduct" %>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Walmart Search</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Destino project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
</head>
<body>

<div class="super_container">
	
	<!-- Header -->

	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="header_container d-flex flex-row align-items-center justify-content-start">

						<!-- Logo -->
						<div class="logo_container">
							<div class="logo">
								<div>Walmart</div>
								<div>Product Search</div>
								<div class="logo_image"><img src="images/logo.png" alt=""></div>
							</div>
						</div>

						

						<!-- Search -->
						<div class="search">
							<form action="#" class="search_form">
								<input type="search" name="search_input" class="search_input ctrl_class" required="required" placeholder="Keyword">
								<button type="submit" class="search_button ml-auto ctrl_class"><img src="images/search.png" alt=""></button>
							</form>
						</div>
 
						
				</div>
			</div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu_container menu_mm">

		<!-- Menu Close Button -->
		<div class="menu_close_container">
			<div class="menu_close"></div>
		</div>

		<!-- Menu Items -->
		<div class="menu_inner menu_mm">
			<div class="menu menu_mm">
				<div class="menu_search_form_container">
					<form action="#" id="menu_search_form">
						<input type="search" class="menu_search_input menu_mm">
						<button id="menu_search_submit" class="menu_search_submit" type="submit"><img src="images/search_2.png" alt=""></button>
					</form>
				</div>
				

				<!-- Menu Social -->
				
				<div class="menu_social_container menu_mm">
					<ul class="menu_social menu_mm">
						<li class="menu_social_item menu_mm"><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					</ul>
				</div>

				<div class="menu_copyright menu_mm">Colorlib All rights reserved</div>
			</div>

		</div>

	</div>
	
	<!-- Home -->

	<div class="home">
		<div class="home_background" style="background-image:url(images/home.jpg)"></div>
		<div class="home_content">
			<div class="home_content_inner">
				<div class="home_text_large">Discover</div>
				<div class="home_text_small">Discover new Products</div>
			</div>
		</div>
	</div>

	<!-- Find Form -->

	<div class="find">
		<!-- Image by https://unsplash.com/@garciasaldana_ -->
		<div class="find_background parallax-window" data-parallax="scroll" data-image-src="images/find.jpg" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="find_title text-center">Find the Details of the Product</div>
				</div>
				<div class="col-12">
					<div class="find_form_container">
						<form action="./Index" id="find_form" class="find_form d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-md-between justify-content-start flex-wrap">
							<div class="find_item">
								<div>Select Product:</div>
								<select name="adventure" id="Product" class="dropdown_item_select find_input">
									<% 
   // Connection c=connection.getConn();
    ResultSet rs=GetProduct.getType();
    //System.out.println("rs: "+rs.next());
    out.println("<option value=\"Select Products\" > Select Products </option>");
    while(rs.next())
    { 
    out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");		
    }
    //c.close(); 
    %>
								</select>
							</div>
							<div class="find_item">
								<div>Select Item:</div>
								<select name="iname"  id="Item" class="dropdown_item_select find_input">
									 out.println("<option value=\"Select Item\" > Select Items </option>");
								</select>
							</div>
							 
							<button class="button find_button">Find</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	 
 
	 
	 

	 

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="js/custom.js"></script>
</body>


<script>
var itemTo = document.getElementById("Item");
var c=0;

Item.addEventListener("click",function(){
	var ty=document.getElementById("Product");
	var str=ty.options[ty.selectedIndex].text;
    console.log("str : " + str); 
	var req=new	XMLHttpRequest();

	req.open('GET','/productSearch/item');
	
	
	req.onload=function(){
		//console.log("response : " + req.responseText);
		var d=JSON.parse(req.responseText);
			console.log("result:" + d);
			console.log(str);
		if(c==0)

			str.on('change',render(d,str));

		c++;

		

	};
	req.send();
	function render(data,val)

	{
		document.getElementById("Item").options.length = 0;
		console.log("testing"+val);

		var t='';

		for(i=0;i<data.length;i++)

			{
			
			if(val==data[i].type)

			t+='<option value="'+data[i].name+'">'+data[i].name+'</option>';
			}

		itemTo.insertAdjacentHTML('beforeEnd',t);

		console.log(data[i]);

	}


   
	

});


</script>
</html>