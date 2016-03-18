<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Register user</h2>
<s:form>
	<s:textfield name="username" label="Username" value="%{username}" />
	<s:textfield name="password" label="Password" value="" />
	<s:textfield name="email" label="Email" value="%{email}" />
	<s:if test="%{id==null}">
		<s:submit value="Create" action="createUserAction" />
	</s:if>
<%-- 	<s:else>
		<s:submit value="Update" action="updateUserAction"/>
	</s:else> --%>
</s:form>

