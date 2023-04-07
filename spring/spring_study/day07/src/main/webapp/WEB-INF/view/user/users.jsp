<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form method="get" modelAttribute="users">
	<form:input type='date' path="sdate"/>
	<form:errors path="sdate"/>
	~
	<form:input type='date' path="edate"/>
	<form:errors path="edate"/>
	<button type="submit">검색</button>
</form:form>