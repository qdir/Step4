<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body bgcolor="#A9F5E1">
	<h1>
		<fmt:message key="paymentdelay.heading" />
	</h1>
	<form:form method="post" commandName="delayPayments">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Date of the delayed payment:</td>
				<td width="20%"><form:input path="date" /></td>
				<td width="60%"><form:errors path="date" cssClass="error" /></td>
			</tr>
		</table>
		<br>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>
>
