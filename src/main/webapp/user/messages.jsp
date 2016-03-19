<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<a style="margin-left: 20px;">Conversations</a>
	<br>

	<div>

		<table
			style="width: 25%; hieght: 200px; margin-left: 20px; float: left;">

			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Ploaia Vladisav</td>
			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Ploaia Vladisav</td>
			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Ploaia Vladisav</td>
			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Adrian Tabirta</td>
			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Dorin Turcan</td>

			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Ploaia Vladisav</td>
			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Adrian Tabirta</td>
			</tr>
			<tr>
				<td><center>
						<img src="../images/menSmile.jpg" class="img_mess">
					</center></td>
				<td>Dorin Turcan</td>

			</tr>

		</table>
	</div>

	<div>
		<table
			style="width: 50%; margin-left: 20px; float: left; background-color: #00FF00;">

			<tr>
				<td align="left">Noroc, cmf?<br>
				<font class="ora_mess">[10:07]</font></td>
			</tr>
			<tr>
				<td align="right">Salut, bine <br>
				<font class="ora_mess">[10:08]</font></td>
			</tr>
			<tr>
				<td align="left">Ai facut lab la APPOO? <br>
				<font class="ora_mess">[10:09]</font></td>
			</tr>
			<tr>
				<td align="right">Da, oleaca )<br>
				<font class="ora_mess">[10:10]</font></td>
			</tr>
			<tr>
				<td align="left"><form>
						Text text text Text text text Text text text Text text textText
						text text Text text text Text text text Text text text <br>
						<font class="ora_mess">[10:11]</font>
					</form></td>
			</tr>
			<tr>
				<td align="right">Da da da da da da da da da <br>
				<font class="ora_mess">[10:12]</font></td>
			</tr>
			<tr>
				<td align="left">1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 <br>
				<font class="ora_mess">[10:13]</font></td>
			</tr>
			<tr>
				<td align="right">Laborator Laborator Laborator Laborator
					Laborator <br>
				<font class="ora_mess">[10:14]</font>
				</td>
			</tr>


		</table>
	</div>
	<br>
	<br>

	<center>
		<form
			style="display: inline-block; margin-left: 20px; margin-top: 20px;"
			method="post" name="msg_form" action="entityMain.jsp">
			<textarea name="mess" rows="4" cols="50"></textarea>
			<br>
			<br> <input style="float: right;" type="submit" value="Send">
		</form>
	</center>




	<br>
	<br>





</body>
</html>