<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/search.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />





<title>Identity</title>
</head>
<body>


<!-- functia de cautare -->
 <script type="text/javascript">
window.onload = function(){ 
	//Get submit button
	var submitbutton = document.getElementById("tfq");
	//Add listener to submit button
	if(submitbutton.addEventListener){
		submitbutton.addEventListener("click", function() {
			if (submitbutton.value == 'Search knowns'){//Customize this text string to whatever you want
				submitbutton.value = '';
			}
		});
	}
}
</script> 



	<!-- <div class="rect" style="top:0px;"></div>   -->
	<!--<li><a href="../About/index.html"> ABOUT</a></li>  -->

<!-- /////////// 15.04.2016 Aici am modificat cu if/else session.logged == true ////  

<li><a href="getCommentsAction">Identity</a></li>

-->


<ul id="menu" >
  <li><a href="getCommentsAction">Identity</a></li>
  <li><a href="getFriendsAction">Knowns</a></li>
  <li><a href="getMessagesById">Messages</a></li>
  <li><a href="getRecomandationsAction">Recomandation</a></li>
  
  <li><INPUT type="text" name="userProfile" class="tftextinput3" name="q" size="21"
					maxlength="120" value="Search knowns"> <INPUT type="submit" value="Find"></li>
  
  <li><a href="logout">Log Out</a></li>
  
<!--   <li><a id="tfheader">
			<form id="tfnewsearch" method="get" action="http://www.google.com">
				<input type="text" id="tfq" class="tftextinput3" name="q" size="21"
					maxlength="120" value="Search knowns">
			</form>
			
		</a>
		</li>  -->
  
</ul> 



<!-- 	<nav style="position:fixed; right:0; left:0;"> -->

			
	
		



	<!-- 	<div id="tfheader">
			<form id="tfnewsearch" method="get" action="http://www.google.com">
				<input type="text" id="tfq" class="tftextinput3" name="q" size="21"
					maxlength="120" value="Search knowns">
			</form>
			<div class="tfclear"></div>
		</div>
 -->



	<!-- <form method="get" action="logout" style="float: right;">
		<input type="submit" value="Log Out">
	</form> -->


<!-- 	<form style="float: left;">
		<a>Identity</a>
	</form>
	<br>
 -->

<!-- 	<form method="get" action="friends.jsp" style="float: left;">
		<input type="submit" value="Knowns">
	</form>
	<br>
	<form method="get" action="messages.jsp" style="float: left;">
		<input type="submit" value="Messages">
	</form>
	<br>
	<form method="get" action="index.jsp" style="float: lest;">
		<input type="submit" value="Recomandation">
	</form>   -->


<!-- 	</nav> -->
	





</body>
</html>








