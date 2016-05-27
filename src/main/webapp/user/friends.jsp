<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>Insert title here</title>
</head>
<body>

	<script language="javascript">
alertCV()
{
	alert("Now user can see your CV");
	}
</script>


	<%@include file="header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



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

	

</body>
</html>