<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html"  %>

 <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<fmt:setBundle basename="messages.common"/>

<fmt:message var="title" key="member.jointitle"/>
<c:url var="action" value="/member/join"/>

<%-- 회원가입하기 창 --%>
<layout:main siteTitle="${title} ">
	<h1>${title} 창 입니다/</h1>
	<form name="registFrm" method="post" action="${action }"
	autocomplete="off" target="ifrmProcess">
	<%-- 아이디 --%>
	<dl>
		<dt>
			<fmt:message key="userId"/></dt>
		<dd>
			<input type="text" name="userId">
		</dd>
	</dl>
	<%-- 비밀번호 --%>
	<dl>
		<dt>
			<fmt:message key="userPw"/></dt>
		<dd>
			<input type="password" name="userPw">
		</dd>
	</dl>
	<%-- 비밀번호 재확인 --%>
		<dl>
		<dt>
			<fmt:message key="userPwRe"/></dt>
		<dd>
			<input type="password" name="userPwRe">
		</dd>
	</dl>
	<%-- 이름(회원명) --%>
	<dl>
		<dt>
			<fmt:message key="userNm"/></dt>
		<dd>
			<input type="text" name="userNm">
		</dd>
	</dl>
	<dl>
		<dt>생년월일</dt>
		<dd>
			<select name="yy" id="year"></select>년
			<select name="mm" id="month"></select>월
			<select name="dd" id="day"></select>일
		</dd>
	</dl>
	
	<!-- 생년월일 -->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="birth" />
				</div>
				<div id="birth_box">
					<span>
					<input type="text"  id="birth_yy" placeholder="년도(4자)"
						maxlength="4" name="birth_yy">
					</span>
					<span>
						<html:selectNum start="1" end="12"  name="birth_mm" label="월" />
					</span>
					<span>
						<input type="text"  id="birth_dd" placeholder="일"
							maxlength="2" name="birth_dd">
					</span>
				</div>
			</div>
	<%-- 성별 --%>
		<dl>
		<dt>
			<fmt:message key="gender"/></dt>
		<dd>
			<input type="text" name="gender">
		</dd>
	</dl>
	
	<div class='terms'>약관</div>
	<div>
			<input type="checkbox" name="agree" value="1" id="agree">
			<label for="agree">
				<fmt:message key="member.agree.terms"/>
			</label>
	</div>
	
	
	<%-- 입력 란, 제출 란 만들기  --%>
	</form>
	<div class="btn">
		<button type="submit">
			<fmt:message key="member.join"/>
		</button>
	</div>
</layout:main>