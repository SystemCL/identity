<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/comments.css" />


<title>Identity</title>

</head>
<body>

	<%@include file="header.jsp"%>
	
	<br>
	<br>


	

	<center>
		<img class="example" src="images/menSmile.jpg">
	</center>
	
	<center>
		
		
	<h1><s:property value="#session['firstName']" /> <s:property value="#session['lastName']" /></h1> <br>
	    Email: <s:property value="#session['email']" /> <br>
        Data nasterii: <s:property value="#session['dBirthday']" /> <br>
        Locatie: <s:property value="#session['location']" /> <br>
        Status: <s:property value="#session['status']" /> <br>

		<%-- <input type="text" value="<%= session.getAttribute("picture") %>" /> --%>
		
	</center>





	<center>
		<s:if test="commentList.size() > 0"> 
		 	
				<table border="1px" cellpadding="8px">
					
					 <tr>
					
					 <td colspan="3" ><center>Opinions</center></td>
				
	
					</tr>
					<s:iterator value="commentList" >
						<tr>
							<td><s:date name="creationDate" format="dd/MM/yyyy" /> <br> <s:property value="message" /></td>
							<td><center><s:property value="pozitiveRating" /></center> <br> <button type="button">UP</button></td>
							<td><center><s:property value="negativeRating" /></center> <br> <button type="button">DOWN</button></td>

						</tr>
					</s:iterator>
				</table>
			</s:if>
	</center>


	<br>
	<br>
	
	
<center>
<form method='post'>

  Comment:<br />
  <textarea name='comment' id='comment'></textarea><br />

  <input type='hidden' name='articleid' id='articleid' value='<? echo $_GET["id"]; ?>' />
 

  <input type='submit' value='Post' />  
</form>
</center>
	
	

<%-- 	<center>
		<div class="test1">
		
			<center>
		<s:if test="commentList.size() > 0"> 
		 	
				<table border="1px" cellpadding="8px">
					
					 <tr>
					
					 <td colspan="3" ><center>Opinions</center></td>
				
	
					</tr>
					<s:iterator value="commentList" >
						<tr>
							<td><s:date name="creationDate" format="dd/MM/yyyy" /> <br> <s:property value="message" /></td>
							<td><center><s:property value="pozitiveRating" /></center> <br> <button type="button">UP</button></td>
							<td><center><s:property value="negativeRating" /></center> <br> <button type="button">DOWN</button></td>

						</tr>
					</s:iterator>
				</table>
			</s:if>
	</center>
		
		
		
		</div>
	</center> --%>





</body>
</html>