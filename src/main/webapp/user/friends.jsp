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
		<table style="width: 50%; height: 50px; overflow-y: scroll;">

			<tr>
				<td>[FOTO]</td>
				<td>Ploaia Vladisav</td>
				<td>
					<form method="get" action="messages.jsp" style="float: right;">
						<input type="submit" value="Send Message">
					</form>
				</td>
				<td>CV access<input type="checkbox" id="checkbox_id"
					onclick="out.alert('daaaa')" value="foo"></td>
			</tr>
			<tr>
				<td>[FOTO]</td>
				<td>Adrian Tabirta</td>
				<td>
					<form method="get" action="messages.jsp" style="float: right;">
						<input type="submit" value="Send Message">
					</form>
				</td>
				<td>CV access<input type="checkbox" name="cv_acces" value="CV"></td>

			</tr>
			<tr>
				<td>[FOTO]</td>
				<td>Dorin Turcan</td>
				<td>
					<form method="get" action="messages.jsp" style="float: right;">
						<input type="submit" value="Send Message">
					</form>
				</td>
				<td>CV access<input type="checkbox" name="cv_acces" value="CV"></td>
			</tr>
			<tr>
				<td>[FOTO]</td>
				<td>Dorin Turcan</td>
				<td>
					<form method="get" action="messages.jsp" style="float: right;">
						<input type="submit" value="Send Message">
					</form>
				</td>
				<td>CV access<input type="checkbox" name="cv_acces" value="CV"></td>
			</tr>
			<tr>
				<td>[FOTO]</td>
				<td>Dorin Turcan</td>
				<td>
					<form method="get" action="messages.jsp" style="float: right;">
						<input type="submit" value="Send Message">
					</form>
				</td>
				<td>CV access<input type="checkbox" name="cv_acces" value="CV"></td>
			</tr>
			<tr>
				<td>[FOTO]</td>
				<td>Dorin Turcan</td>
				<td>
					<form method="get" action="messages.jsp" style="float: right;">
						<input type="submit" value="Send Message">
					</form>
				</td>
				<td>CV access<input type="checkbox" name="cv_acces" value="CV"></td>
			</tr>

		</table>
	</center>


</body>
</html>