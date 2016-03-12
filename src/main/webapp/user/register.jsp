<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form>
	<s:textfield name="username" label="Name" value="%{username}" />
	<s:textfield name="password" label="Surname" value="%{password}" />
	<s:if test="%{idAccount==null}">
		<s:submit value="Create" action="registerUser" />
	</s:if>
	<s:else>
		<s:submit value="Update" action="registerUser" />
	</s:else>
</s:form>