<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/comments.css" />
<link type="text/javascript" href="js/scripts.js" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<title>Complete user profile</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<br/><br/><br/>
	
	
	<s:if test="%{picture==null}">
		 <center><img class="example" height="200" width="200"  src="images/holder.png"></center>
	</s:if>
	 <s:else>
		<center><img  height="200" width="200" src="<s:url  action="imageAction" ><s:param name="userProfileId" value="%{idProfile}" /></s:url>" /></center>
	</s:else> 
	
	<%-- <center><img  height="200" width="200" src="<s:url  action="imageAction" ><s:param name="userProfileId" value="%{idProfile}" /></s:url>" /></center> --%>
	<br/><br/>
	<center><s:form method="POST" enctype="multipart/form-data">
		<s:textfield name="firstName" label="Nume" value="%{firstName}" />
		<s:textfield name="lastName" label="Prenume" value="%{lastName}" />
		<s:date name="dBirthday" var="%{dBirthday}" />
        <s:textfield name="email" label="Email:" value="%{email}" /> 
		<s:textfield name="location" label="Oras" value="%{location}" />
		<s:textfield name="status" label="Status" value="%{status}" />
		<s:file name="profileImage" label="Image" value="%{profileImage}" />
		<s:if test="%{idProfile==null}">
			<s:submit value="Save Profile" action="saveProfileActionNew" />
		</s:if>
		<s:else>
			<s:submit value="Update" action="updateProfileActionNew" />
		</s:else>
	</s:form></center>
</body>
</html>