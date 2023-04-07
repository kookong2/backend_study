<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="html"  tagdir="/WEB-INF/tags/html" %>
<fmt:setBundle basename="messages.common" />
<!--  -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<fmt:message var="title" key="member.jointitle" />
<c:url var="action" value="/member/join" />

<%-- 회원가입하기 창 --%>
<layout:main siteTitle="${title}">
	<div id="joinbox" class="joinbox">
		<form action="${action}" method="post" name="registFrm"
			autocomplete="off" target="ifrmProcess" class="join-content">
			<!-- 회원가입 타이틀 -->
			<h2>${title}</h2>

			<!-- 이름(회원명)-->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="userNm" />
				</div>
				<div class="user-box">
					<input type="text" id="joinNm" placeholder="이름을 입력해 주세요"
						maxlength="20" name="userNm">
				</div>
			</div>
			<!-- 아이디 -->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="userId" />
				</div>
				<div class="user-box">
					<input type="text" id="joinId" placeholder="아이디를 입력해 주세요"
						maxlength="20" name="userId">
				</div>
			</div>
			<!-- 비밀번호 -->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="userPw" />
				</div>
				<div class="user-box">
					<input type="password" id="joinPw" placeholder="비밀번호를 입력해 주세요"
						maxlength="20" name="userPw">
				</div>
			</div>
			<!-- 비밀번호 재확인  -->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="userPwRe" />
				</div>
				<div class="user-box">
					<input type="password" id="joinPwRe" placeholder="비밀번호를 다시 입력해 주세요"
						maxlength="20" name="userPwRe">
				</div>
			</div>
			<!-- 전화번호 -->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="mobile" />
				</div>
				<div class="user-box">
					<input type="text" id="mobile" placeholder="전화번호를 입력해 주세요"
						maxlength="20" name="mobile">
				</div>
			</div>
			<!-- 생년월일 -->
			<!-- 
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
			 -->
			<!-- 생년월일 -->

			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="birth" />
				</div>
				<div class="user-box" id="birth_box">
					<select name="birth_yy" id="year"></select>
					<select name="birth_mm" id="month"></select>
					<select name="birth_dd" id="day"></select>
				</div>
			</div>

			<!-- 성별 -->
			<div class="form-group">
				<div class="font-size-15 margin-bottom-10">
					<fmt:message key="gender" />
				</div>
				<div>
					<select name="<fmt:message key="gender"/>" class="option_box">
						<option value="<fmt:message key="man"/>">
							<fmt:message key="man" />
						</option>
						<option value="<fmt:message key="woman"/>">
							<fmt:message key="woman" />
						</option>
						<option value="<fmt:message key="not.gender"/>">
							<fmt:message key="not.gender" />
						</option>
					</select>
				</div>
			</div>

			<!-- 약관 동의 -->
			<div class="form-group margin-top-25">
				<input type="checkbox" name="agree" value="1" id="agree"> 
					<label for="agree"> 
						<fmt:message key="member.agree.terms" />
					</label>
			</div>
			
			<!-- 회원가입 버튼 -->
			<div class="form-group btn-group">
				<button style="background-color : #ffa07a;">취소</button>
				<button type="submit" style="background-color : #87ceeb; padding-left:10px; ">
					<fmt:message key="member.join"/>				
				</button>
			</div>
		</form>
	</div>
</layout:main>
