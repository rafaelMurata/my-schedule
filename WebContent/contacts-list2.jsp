<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Contacts2 using taglib</title>
</head>
<body>
	<c:import url="header.jsp"/>
	<jsp:useBean id="dao" class="br.com.rafaelmurata.dao.ContactDAO"></jsp:useBean>
	<table>
		<c:forEach var="contact" items="${dao.list}">

			<tr>
				<td>${contact.name}</td>
				<td>${contact.email}</td>
				<td>${contact.adress}</td>
				<td><fmt:formatDate  value="${contact.dateOfBirth.time}" pattern="dd/MM/yyyy"/> </td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="footer.jsp"/>
</body>
</html>