<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="action" value="/admin/board/config" />
<layout:admin>
	<div class='main_tit'>게시판 등록</div>
	
	<form name="saveFrm" method="post" action="${action}" target="ifrmProcess" autocomplete="off">
		<table class='table_cols'>
			<tr>
				<th>게시판 ID</th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<th>게시판이름</th>
				<td>
					<input type="text" name="boardNm">
				</td>			
			</tr>
			<tr>
				<th>사용여부</th>
				<td>
					<input type="radio" name="isUse" value="1" id="isUse_1">
					<label for="isUse_1">사용</label>
					<input type="radio" name="isUse" value="0" id="isUse_0" checked>
					<label for="isUse_0">미사용</label>	
				</td>
			</tr>
			<tr>
				<th>위지윅에디터</th>
				<td>
					<input type="radio" name="useEditor" value="1" id="useEditor_1" checked>
					<label for="useEditor_1">사용</label>
					<input type="radio" name="useEditor" value="0" id="useEditor_0">
					<label for="useEditor_0">미사용</label>
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type="checkbox" name="attachFileType" value="basic" id="attachFileType_basic">
					<label for="attachFileType_basic">일반파일</label>
					<input type="checkbox" name="attachFileType" value="image" id="attachFileType_image">
					<label for="attachFileType_image">이미지파일</label>
					
				</td>
			</tr>
			<tr>
				<th>한페이지 게시글 갯수</th>
				<td>
					<input type="number" name="postsPerPage">
				</td>
			</tr>
			<tr>
				<th>페이지 구간 갯수</th>
				<td>
					<input type="number" name="pageRanges">
				</td>
			</tr>
			<tr>
				<th>댓글 사용</th>
				<td>
					<input type="radio" name="useComment" value="1" id="useComment_1">
					<label for="useComment_1">사용</label>
					<input type="radio" name="useComment" value="0" id="useComment_0" checked>
					<label for="useComment_0">미사용</label>
				</td>
			</tr>
			<tr>
				<th>목록 상단</th>
				<td>
					<textarea id="boardTopHtml" name="topHtml"></textarea>
				</td>
			</tr>
			<tr>
				<th>목록 하단</th>
				<td>
					<textarea id="boardBottomHtml" name="bottomHtml"></textarea>
				</td>
			</tr>
		</table>
		<div class='btns'>
			<button type="reset">다시입력</button>
			<button type="submit">등록하기</button>
		</div>
	</form>
</layout:admin>