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


<title>Identity</title>

</head>
<body>

	<%@include file="header.jsp"%>

	<br>
	<br>
	<br>
    
	<s:if test="%{picture==null}">
		 <center><img class="example" height="200" width="200"  src="images/holder.png"></center>
	</s:if>
	 <s:else>
		<center><img  height="200" width="200" src="<s:url  action="imageAction" ><s:param name="userProfileId" value="#session['idProfile']" /></s:url>" /></center>
	</s:else> 
	<div id="element2">
				<p>
					<s:property value="#session['status']" />
				</p>
	</div>
	<%-- <center>
		<form style="display: inline;">
			<div id="element1">
				<s:property value="#session['picture']" />
			</div>
			
			
		</form>
	</center> --%>

	<br>
	<br>
	<br>
	<br>
	<br>



	<center>
			<h1>
				<s:property value="%{profile.firstName}" />
				<s:property value="%{profile.lastName}"  />
			</h1>
			<br> Email:
			<s:property value="%{profile.email}" />
			<br> Data nasterii:
			<s:date name="%{profile.dBirthday}" format="dd MMM yyyy" />
			<br> Locatie:
			<s:property value="%{profile.location}" />
			<br> Status:
			<s:property value="%{profile.status}" />
			<br>
	</center>
	<br>


	<center>
		<s:if test="commentList.size() > 0">

			<table border="1px" cellpadding="8px">

				<tr>

					<td colspan="6"><center>Opinions</center></td>


				</tr>
				<s:iterator value="commentList">
					<tr>
						<td><s:date name="creationDate" format="dd/MM/yyyy"  /></td>
						<td><s:property value="message" /></td>

				   <td>
				   
				     <a href=<s:url action="rateUpAction">
						<s:param name="idMessUpDown" value="%{idMessage}" />
					 </s:url>>
						<img alt="Up" width="25px" height="25px" src=<s:url value="/images/up.png"/>>
				    </a>
				    <a href=<s:url action="rateDownAction">
						<s:param name="idMessUpDown" value="%{idMessage}" />
					</s:url>>
						<img alt="Down" width="25px" height="25px" src=<s:url value="/images/down.png"/>>
				   </a>
				   <td>
				   <s:property value="pozitiveRating" /> Up
				   </td>
				   <td>
				   <s:property value="negativeRating" /> Down
				   </td>
				   
				  </td>
				</tr>
				</s:iterator>
			</table>
		</s:if>
	</center>


<!--  Trebuie de modificat pentru ca sa afiseze lista de profile pe pagina entityMain.jsp -->
<center>
		<s:if test="profileSearchList.size() > 0">

			<table border="1px" cellpadding="8px">

				<tr>

					<td colspan="6"><center>Profiles</center></td>


				</tr>
				<s:iterator value="profileSearchList">
					<tr>
						<td><s:property value="idProfile" /></td>
						<td><s:property value="firstName " /></td>
						<td><s:property value="lastName " /></td>
						<td><s:property value="location " /></td>
						
<!-- 				   <td>
				   

				   
				  </td> -->
				</tr>
				</s:iterator>
			</table>
		</s:if>
	</center>

	<br>
	<br>
	
	
	 

	<center>
		<h2>Comment</h2>
		<s:form>
			<s:textfield name="message" label="Comentariu" value="%{message}" />
			<s:if test="%{id==null}">
				<s:submit value="Create comment" action="addCommentAction" />
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