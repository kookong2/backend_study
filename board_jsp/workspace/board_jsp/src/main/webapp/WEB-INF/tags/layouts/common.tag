<%@ tag pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<%@ attribute name="siteTitle"%>
<%-- 관리자가 들어가는 페이지(css,js) 다르게 설정 --%>
<c:url var="commonCss" value="${isAdmin==null? '/css/style.css' : '/css/admin/style.css'}"/>
<c:url var="commonJs" value="${isAdmin==null? '/js/common.js' : '/js/admin/common.js'}"/>

<!DOCTYPE html>
<html>
	<head>
		<c:if test=" ${!empty siteTitle }">
			<title>${siteTitle }</title>
		</c:if>
		<!-- 스크롤바 만들기 -->
		<!-- 
		<meta name="veiwport" content="width=device-width,user-scalable=yes, initial-scale=1,minimum-scale=1,maximum-scale=3">
		 -->
		<%--css 참고~ --%>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
		<link rel="stylesheet" type="text/css" href="${commonCss}">
		
		<c:if test="${!empty addCss }">
			<c:forEach var="cssFile" items="${addCss }">
				<link rel="stylesheet" type="text/css" href="<c:url value='/css/'/>${cssFile}.css"/>
			</c:forEach>
		</c:if>
		<script src="${commonJs }"></script>
		<c:if test="${!empty addScript }">
			<c:forEach var="jsFile" items="${addScript }">
				<script src="<c:url value='/js/'/>${jsFile}.js"></script>
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