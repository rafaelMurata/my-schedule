<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="value" required="false" %>

<c:if test="${not empty label }">
	<label for="${id}">${label}</label>
</c:if>

<input type="text" id="${id}" name="${id}" value="${value}" />

<script>
	$( "#${id}" ).datepicker({showAnim: "slideDown"});
</script>