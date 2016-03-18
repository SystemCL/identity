<%@ taglib prefix="s" uri="/struts-tags"%>

<body bgcolor=''>
<s:form action="loginauth" theme="simple">
	<center>
		<table width="200">
			<tr height="30">
				<td width="200" colspan="2"><s:if test="hasActionErrors()">
						<div class="errors">
							<s:actionerror />
						</div>
					</s:if> <s:property value="exception" /></td>

			</tr>
			<tr>
				<td colspan="2" width="200" align="left" style="background: #D3D3D3"><b>Login
					Here</b></td>
			</tr>
			<tr>
				<td align="left">Username:</td>
				<td align="left"><s:textfield name="username" /></td>
			</tr>
			<tr>
				<td align="left">Password:</td>
				<td align="left"><s:password type="text" name="password" /></td>
			</tr>
			<tr>
				<td align="left"></td>
				<td align="left"><input type="image" name="login"
					value="Login" src="images/login.png" style="height:33px"></td>
			</tr>
			<tr>
			<tr>
				<td align="left" colspan="2"><a href="register">Register new User</a></td>
						</tr>
			
			</tr>
		</table>
	</center>
</s:form>