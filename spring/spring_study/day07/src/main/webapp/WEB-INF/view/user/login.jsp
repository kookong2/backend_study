<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="action" value="/user/login"/>
<form:form method="post" action="${action}" modelAttribute="memberLogin">
	<form:errors element="div"/>
	<!-- 아이디 -->
	<dl>
		<dt>
			<spring:message code="user.userId"/>
		</dt>
		<dd>
			<form:input path="userId"/>
			<form:errors path="userId" element="div"/>
		</dd>
	</dl>
	<!-- 비밀번호 -->
	<dl>
		<dt>
			<spring:message code="user.userPw"/>
		</dt>
		<dd>
			<form:password path="userPw"/>
			<form:errors path="userPw" element="div"/>
		</dd>
	</dl>
	
	<!-- 아이디 저장 -->
	<div>
		<spring:message var="savedId" code="user.savedId"/>
		<form:checkbox path="savedId" value="true" label="${savedId}"/>
	</div>
	<button type="submit">
		<spring:message code="user.login"/>
	</button>
</form:form>