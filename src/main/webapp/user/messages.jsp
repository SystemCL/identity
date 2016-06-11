<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/conversationTable.css" />

<title>Messages</title>
</head>
<body>

	<%@include file="header.jsp"%>


<!-- id="example" -->
<h3 style="margin-top:-60px">
<center><a>
						<s:property value="#session['firstName']" />
	  					<s:property value=" " />
						<s:property value="#session['lastName']" />
</a></center>
</h3>

<br/>


<center><div>
			<s:if test="profileConversations.size() > 0">
			<table border="1px"  style="float:left; width:20%; margin-left:20px; margin-right:110px;">
				<tr>
					<td colspan="6" bgcolor="#E6E6FA"><center>Conversations</center></td>
				</tr>
				<s:iterator value="profileConversations">
					<tr>
						
						  <td>
	 					<a href=<s:url action="getMessagesBySenderId">
			 			<s:param name="idProfileOfConversation" value="%{idProfile}" />
						 </s:url>
						>
						<!--  <img alt="Up" width="50" height="50px" src=<s:url value="%{image}"/>>  -->
						<s:if test="%{profile.picture==null}">
		                  <img class="example" height="70" width="70"  src="images/holder.png">
	                   </s:if>
	                   <s:else>
						 <img  height="70" width="70" src="<s:url  action="imageAction" ><s:param name="userProfileId" value="%{idProfile}" /></s:url>" />
					   </s:else>	 
						 </a>
 
						 </td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="firstName " /></td>
						
			
	
				<%-- ultima data cind a fost online		<td><s:date name="lname" format="text"  /></td>
						<td><s:property value="lastname" /></td> --%>
						
				</tr>
				</s:iterator>
			</table>
		</s:if>
	

	
	
		<s:if test="listMessages.size() > 0">
			<table  border="1px" cellpadding="8px" style="float:left; width:40%;  background-color: #fff; position:inline; ">
				<tr>
					<td colspan="6"><center>Messages</center></td>
				</tr>
				<s:iterator value="listMessages">
					<tr>
						<s:if test="idSender == #session['profile_id']">
						<!-- Mesajele mele vor fi pe dreapta  -->
							<td align="right" bgcolor="#90EE90">
							<s:property value="message" /><br>
							<font class="ora_mess"><s:date name="creationDate" nice="true"  /></font>
							</td>
						</s:if>
						<s:else>
							<td align="left" bgcolor="#B0C4DE">
							<s:property value="message" /><br>
							<font class="ora_mess"><s:date name="creationDate" nice="true"  /></font>
							</td>
						</s:else> 

						<%-- <td><s:date name="message" format="text"  /></td>
						<td><s:property value="message" /></td> --%>
				</tr>
				</s:iterator>
			</table>
		</s:if>
		
</div></center>
		
		<br>
        <br>
      
        
     <center><div style="clear:both;">
			<form
				style="display: inline-block; margin-left: 20px; margin-top: 20px;"
				method="post" name="msg_form" >
				<textarea name="message" style="overflow:hidden" maxlength="150" rows="4" cols="50"  placeholder="Scrie un mesaj..."></textarea>
				<s:hidden name="idSender" value="%{idSender}"/>
				<br>
				<br>
					<s:submit value="Trimite" action="sendMessageAction"  />
				<!-- <br> <input style="float: right;" type="submit" value="Send"> -->
			</form>
	</div></center>
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        
       
	<jsp:include page="footer.jsp" />

</body>
</html>