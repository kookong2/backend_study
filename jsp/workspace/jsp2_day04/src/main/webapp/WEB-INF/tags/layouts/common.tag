<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<%@ attribute name="title" %>

<!DOCTYPE html>
<html>
	<head>
		<title>${title == null ? '사이트 제목...' : title}</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
		<c:if test="${! empty addCss}">
			<c:forEach var="css" items="${addCss}">
				<link rel="stylesheet" type="text/css" href="<c:url value='/css/'/>${css}.css"/>
			</c:forEach>
		</c:if>
		
		<script src="<c:url value='/js/common.js'/>"/></script>
		
		<c:if test="${! empty addScript}">
			<c:forEach var="js" items="${addScript}">
				<script src="<c:url value='/js/'/>${js}.js"></script>
			</c:forEach>
		</c:if>		
		
		
	</head>
	<body>
		<header>
			<jsp:invoke fragment="header"/>
		</header>
		<main>
			<jsp:doBody/>
		</main>
		<footer>
			<jsp:invoke fragment="footer"/>
		</footer>
	</body>
</html>
