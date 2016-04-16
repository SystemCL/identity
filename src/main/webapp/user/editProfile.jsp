<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/comments.css" />
<link  type="text/javascript" href="js/scripts.js" />



 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>


<title>Identity</title>

</head>
<body>

	<%@include file="header.jsp"%>

	<br>
	<br>
	<br>









<%-- 	<center>
		<form style="background-color: #83c5c5; width: 30%;">
			<h1>
				<s:property value="#session['firstName']" />
				<s:property value="#session['lastName']" />
			</h1>
			<br> Email:
			<s:property value="#session['email']" />
			<br> Nascut:
			<s:date name="#session['dBirthday']" nice="true" />
			<br> Data nasterii:
			<s:date name="#session['dBirthday']" format="dd MMM yyyy" />
			<br> Locatie:
			<s:property value="#session['location']" />
			<br>
			  Status: <s:property value="#session['status']" /> <br>

			<input type="text" value="<%= session.getAttribute("picture") %>" />
		</form>
	</center> --%>
	<br>






<center>
<h2>Edit Profile</h2>



<form name="form-upload" action="POST" action="upload.jsp"  enctype="multipart/form-data">
<input type=file name="ufile">
<input type="submit" name="submit" value="submit">
</form>

</br>
</br>
</br>

<s:form>
    <img class="example" src="images/menSmile.jpg">
  

<%--     <s:action name="Change photo" action="Open"/> --%>
<!-- <p>Date: <input type="text" id="datepicker"></p> -->

	<s:textfield name="username" label="Nume" value="%{#session.firstName}" />
	<s:textfield name="password" label="Prenume" value="%{#session.lastName}" />
	Date: <input name="dBirthday" type="text" id="datepicker" />
 
  
	<s:textfield id="datepicker" name="dBirthday" label="Data Nasterii:" value="%{#session.dBirthday}" />

	<s:textfield name="email" label="Email:" value="%{#session['email']}" />
	<s:textfield name="location" label="Oras" value="%{#session['location']}" />
	<s:textfield name="status" label="Status" value="%{#session['status']}" />
	<s:if test="%{id==null}">
		<s:submit value="Save Profile" action="saveProfileAction" />
	</s:if>
<%-- 	<s:else>
		<s:submit value="Update" action="updateUserAction"/>
	</s:else> --%>
</s:form>
</center>


	<br>
	<br>
	<br>

<a>------------Change password-------------</a>
<a>---------------Instructions-------------</a>

	<jsp:include page="footer.jsp" />

</body>
</html>