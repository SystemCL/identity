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
<!-- loadMainPage
getCommentsAction -->

	<ul id="menu" >
	  <li><a href="loadMainPage">Identity</a></li> <!-- loadMainPage --> <!-- getCommentsAction -->
	  <li><a href="getFriendsSearch">Knowns</a></li>
	  <li><a href="getConversation">Messages</a></li> <!-- getMessages -->
	  <li><a href="getRecomandationsAction">Recomandation</a></li>
	  <li><a href="getProfile">Edit your profile</a></li>
	  
	  <li><INPUT type="text" name="userProfile" class="getFriendsSearch" name="q" size="21"
						maxlength="120" value="Search knowns"> <INPUT type="submit" value="Find"></li>
	  
	  <li><a href="getFriendsSearch">Search</a> </li>
	  
	  
<%-- 	  <li><a>Logged as:
	  					<s:property value="#session['firstName']" />
	  					<s:property value=" " />
						<s:property value="#session['lastName']" />
	  </a>					
	  </li> --%>
	   <li><a href="logout">Log Out</a></li> 
	 
	</ul> 


</body>
</html>








