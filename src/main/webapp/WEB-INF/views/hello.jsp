<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body bgcolor="#A9F5E1">
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>Payments of the loan</h3>
	<c:forEach items="${model.products}" var="prod">
		<span style="background-color: Chartreuse">Identifier: 
		<c:out value="${prod.identifier}" /> Expiration date: <c:out value="${prod.expiringdate}" /> <i><c:out value="${prod.fee}" /></i> 
		<i>$<c:out value="${prod.paid}" /></i></span>
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="delayPayments.htm"/>">Delay payment</a>
	<br>
</body>
</html>