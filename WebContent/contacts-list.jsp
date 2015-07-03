<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<%@ page import="java.util.*,br.com.rafaelmurata.dao.*,br.com.rafaelmurata.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Contacts</title>
</head>
<body>
	<c:import url="header.jsp"/>
	<table>
		<%
			ContactDAO dao = new ContactDAO();
			List<Contact> contacts = dao.getList();
			for (Contact contact : contacts) {
		%>
		<tr>
			<td><%=contact.getName()%></td>
			<td><%=contact.getEmail()%></td>
			<td><%=contact.getAdress()%></td>
			<td><%=contact.getDateOfBirth().getTime()%></td>
			<td>
				<a href="contacts-change.jsp?id=<%=contact.getId()%>&name=<%=contact.getName()%>&email=<%=contact.getEmail()%>&adress=<%=contact.getAdress()%>&dateOfBirth=<%=contact.getDateOfBirth().getTime()%>">
					<input type="button" value="Change" /></a>
				<a href="mvc?logic=RemoveContactLogic&id=<%=contact.getId()%>">
					<input type="button" value="Remover" />
				</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
		<c:import url="footer.jsp"/>
</body>
</html>