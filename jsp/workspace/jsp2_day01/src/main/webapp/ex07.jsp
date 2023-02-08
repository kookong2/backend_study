<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num1" value="101" />
<c:if test="${num1  == 100}">
	<h2>100이다</h2>
</c:if>
<c:if test="${num1 != 100}">
	<h1>100이 아니다</h1>
</c:if>
${ num1 == 100 ? "<h1>100이다</h1>" : "<h1>100이 아니다.</h1>" }


<c:if test="${ ! empty param.str }">
	${param.str}
</c:if>