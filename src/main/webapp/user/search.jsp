<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:if test="listProfiles.size() > 0"> <!-- listProfile  -->
			<center><table border="1px" cellpadding="8px" id="example">
				<tr>
					<td colspan="6"><center>Profiles</center></td>
				</tr>
				<s:iterator value="listProfiles"> 
					<tr>
					
						
					<td align="center">
					                <img alt="Image" width="50" height="50px" value="/images/menSmile.jpg"/> 
									
									<s:property value="firstName" /><br>
									<s:property value="lastName" /><br>
									<s:submit value="Find" action="addFriend" />
		
					</td>
							
					
				</tr>
				</s:iterator>
			</table></center>
		</s:if>

</body>
</html>