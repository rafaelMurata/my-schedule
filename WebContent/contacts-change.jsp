<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="murata" %>

<c:import url="header.jsp"/>
 Change contact: <br/>
<form action="mvc" method="POST">
    Id:     <input type="text"  id="id" name="id" value="${param.id}" /><br/>
    Name:   <input type="text"  id="name" name="name" value="${param.name}"/><br/>
    E-mail: <input type="text"  id="email" name="email" value="${param.email}"/><br/>
    Adress: <input type="text"  id="adress" name="adress" value="${param.adress}"/><br/>
	Date of Birth: <murata:fieldDate id="dateOfBirth"  value="${param.dateOfBirth}"/><br/>
    <input type="hidden" name="logic" value="ChangeContactLogic"/>
    <input type="submit" value="Send"/>
</form>
<c:import url="footer.jsp" />