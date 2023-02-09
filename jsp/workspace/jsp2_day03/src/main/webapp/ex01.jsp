<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util"  tagdir="/WEB-INF/tags" %>
<util:line size="30" />
<c:set var="num" value="100" />
${num}
<util:box color="blue">
	<h1>Hi</h1>
	${num}
</util:box>