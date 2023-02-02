<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 헤더 부분 -->
<jsp:include page="../outline/header.jsp" />

<!-- 메인 부분 -->
<section id="register">
	<form name="frmRegist" method="post" action="/kanban/kanban" target="ifrmProcess">
		<div class="select_status">
			<input type="radio" name="status" value="READY" id="status_ready" checked>
			<label for="status_ready">준비중</label>
			
			<input type="radio" name="status" value="PROGRESS" id="status_progress">
			<label for="status_progress">진행중</label>
			
			<input type="radio" name="status" value="DONE" id="status_done">
			<label for="status_done">완료</label>
		</div>
		<input type="text" name="subject" placeholder="작업 내용 입력...">
		<button type="submit">등록하기</button>
	</form>
</section>

<!-- 작업 목록 출력  -->
<section id="works">
	<jsp:include page="work_list.jsp"/>
</section>

<!-- 푸터 부분 -->
<jsp:include page="../outline/footer.jsp" />