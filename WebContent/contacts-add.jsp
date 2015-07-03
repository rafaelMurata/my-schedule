<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="murata" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Contacts</title>
</head>
	<body>
	<c:import url="header.jsp"/>
		<form action="mvc" method="POST">
				Name: <input type="text" name="name"/></br>
				E-mail: <input type="text" name="email"/></br>
				Adress: <input type="text" name="adress"/></br>
				Date of Birth: <murata:fieldDate id="dateOfBirth"/></br>
			    <input type="hidden" name="logic" value="AddContactLogic"/>	
				<input type="submit" value="save"/>
		</form>
		<c:import url="footer.jsp" />
	</body>
</html>