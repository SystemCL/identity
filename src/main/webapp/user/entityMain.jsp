<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/bar.css" />
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
		<h1>Vasile Ion Ion</h1>
		<input type="text" value="<%= session.getAttribute("username") %>" />
	</center>


	<center>
		<ul style="list-style-type: none;">
			<li>Chisinau</li>
			<li>vasileion@gmail.com</li>
			<li>+37368001122</li>
			<li>My school</li>
			<li>Info</li>
		</ul>
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
		<div class="test1">
			<ul>
				<li>Item
					<button type="button">UP</button>
					<button type="button">UP</button>
				</li>
				<li>Item</li>
				<li>Item</li>
				<li>Item</li>
				<li>Item</li>
				<li>Item</li>
			</ul>
		</div>
	</center>




</body>
</html>