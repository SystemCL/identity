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
	<br>

<center>
<form style="display: inline;">
				  <div id="element1">
				<img class="example" src="images/menSmile.jpg">
				</div>
				<div id="element2">
				<p><s:property value="#session['status']" /></p>
				</div>
</form>
</center>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	
	


	<center>
		<form style="background-color: #83c5c5;   width: 30%;">
	<h1><s:property value="#session['firstName']" /> <s:property value="#session['lastName']" /></h1> <br>
	    Email: <s:property value="#session['email']" /> <br>
        Nascut: <s:date name="#session['dBirthday']" nice="true" /> <br>
        Data nasterii: <s:date name="#session['dBirthday']" format="dd MMM yyyy" /> <br>
        Locatie: <s:property value="#session['location']" /> <br>
      <%--   Status: <s:property value="#session['status']" /> <br> --%>
       
		<%-- <input type="text" value="<%= session.getAttribute("picture") %>" /> --%>
		</form>
	</center>
	<br>


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
<form method='post' action ="addCommentAction">

  Comment:<br />
  <textarea name='message' id='comment' rows="4" cols="50"></textarea><br>
  <input type='hidden' name='message' id='articleid' value="%{message}" />
  <input type='submit' value='Post' />  
</form>
</center>




<center>
<h2>Comment</h2>
<s:form>
	<s:textfield name="message" label="Comentariu" value="%{message}" />
	<s:if test="%{id==null}">
		<s:submit value="Post" action="addCommentAction" />
	</s:if>
<%-- 	<s:else>
		<s:submit value="Update" action="updateUserAction"/>
	</s:else> --%>
</s:form>
</center>




<br>
<br>
<br>
	

<jsp:include page="footer.jsp" />

</body>
</html>