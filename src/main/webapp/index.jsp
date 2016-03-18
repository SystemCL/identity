<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css" />
<title>Entity</title>
</head>
<body>
	<!-- <b><font size="9" color="#5F9EA0"><center>Entity</center></font></b> -->
	<h2 class='retroshadow'>Identity</h2>
</head>
<body>



	<h1 style="text-align: center">
		<b>Welcome. Please login. </b>
	</h1>
		<s:form action="loginauth">
			<fieldset>
				<p>
					<input s:type="text" required value="Username"
						onBlur="if(this.value=='')this.value='Username'"
						onFocus="if(this.value=='Username')this.value='' ">


				</p>
				<p>
					<input s:type="password" required value="Password"
						onBlur="if(this.value=='')this.value='Password'"
						onFocus="if(this.value=='Password')this.value='' ">

				</p>
				<p>
					<a href="#">Forgot Password?</a>
				</p>
				<p>
					<input type="submit" value="Login">
				</p>
			</fieldset>
		</s:form>
		<p>
			<span class="btn-round">or</span>
		</p>


		<center>
			<h1>
				<strong>Register</strong>
			</h1>
		</center>

		<s:form>
			<fieldset>
				<p>
					<input type="text" required value="Nume"
						onBlur="if(this.value=='')this.value='Nume'"
						onFocus="if(this.value=='Nume')this.value='' ">
				</p>
				<p>
					<input type="text" required value="Prenume"
						onBlur="if(this.value=='')this.value='Prenume'"
						onFocus="if(this.value=='Prenume')this.value='' ">
				</p>
				<p>
					<input type="text" required value="Data nasterii"
						onBlur="if(this.value=='')this.value='Data nasterii'"
						onFocus="if(this.value=='Data nasterii')this.value='' ">
				</p>
				<p>
					<input type="text" required value="Email"
						onBlur="if(this.value=='')this.value='Email'"
						onFocus="if(this.value=='Email')this.value='' ">
				</p>

				<p>
					<input type="submit" value="Register">
				</p>
			</fieldset>
		</s:form>


		<!--  
<p style="padding-left: 35px">
<button class="facebook">Login Using Facbook</button>
</p>
-->

	</div>
	<!-- end login -->
</body>
</html>


