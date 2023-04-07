<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form method="post" enctype="multipart/form-data">
	<input type="file" name="files" multiple="multiple"/>
	<button type="submit">업로드</button>
</form>