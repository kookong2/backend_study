<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<fmt:setBundle basename="messages.common" />
<fmt:message var="siteTitle" key="member.logintitle" />
<c:url var="action" value="/member/login" />

<layout:main siteTitle="${siteTitle}">
	<h1>${siteTitle}창 입니다. 로그인해주세요</h1>
	<form method="post" action="${action }" target="ifrmProcess" autocomplete="off">
	<%-- 아이디 입력창 --%>
	<dl>
		<dt>
			<fmt:message key="userId"/></dt>
		<dd>
			<input type="text" name="userId" value="${cookie.saverId.value}">
		</dd>
	</dl>
	<%-- 비밀번호 입력창 --%>
	<dl>
		<dt>
			<fmt:message key="userPw"/></dt>
		<dd>
			<input type="password" name="userPw">
		</dd>
	</dl>	
	<%-- 아이디 저장칸 메모리 --%>
	<div>
		<input type="checkbox" name="saveId" value="1" id="saveId" >
		<label for="saveId">
			<fmt:message key="member.saveId"/>
		</label>
	</div>
	<button type="submit">
		<fmt:message key="member.login"/>
	</button>
	</form>

</layout:main>