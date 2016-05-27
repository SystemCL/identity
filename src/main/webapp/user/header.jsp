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

 <ul id="bkgmenu" >
</ul> 

	<ul id="menu" >
	  <li><a href="loadMainPage">Identity</a></li> <!-- loadMainPage --> <!-- getCommentsAction -->
	  <li><a href="getAllFriendsAction">Knowns</a></li>
	  <li><a href="getConversation">Messages</a></li> <!-- getMessages -->
	<!--   <li><a href="getRecomandationsAction">Recomandation</a></li> -->
	  <li><a href="getProfile">Edit your profile</a></li>
	  
	  	 <li>
	 <s:form style="display:inline; "  action="getFriendsSearchAction" theme="simple">
	  		<s:textfield name="numeFriend" size="20" />
	  		<INPUT type="submit" value="Find">
	  		
	  </s:form>
	 </li>
	  
 	  <li><a>Logged as:
	  					<s:property value="#session['firstName']" />
	  					<s:property value=" " />
						<s:property value="#session['lastName']" />
	  </a>					
	  </li> 

	  	  
 	   <li><a href="logout">Log Out</a></li> 
	 
	</ul> 
	
	<br>
    <br>
    <br>
    <br>
    <br>
    

<table>
<tr>
<td>
	  
	  </td>
	  </tr>
	  </table>


</body>
</html>








