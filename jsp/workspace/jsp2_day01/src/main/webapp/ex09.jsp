<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="exam.Book, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${num1}
<%
	List<Book> books = Arrays.asList(
										new Book("책1", 10000), 
										new Book("책2", 20000),
										new Book("책3", 30000));	
	
	request.setAttribute("books", books);
	String[] fruits = { "Apple", "Orange", "Mango" };
	request.setAttribute("fruits", fruits);
%>
<c:forTokens var="item" items="apple,Mango#Orange_melon" delims=",#_">
${item}<br>
</c:forTokens>

<ul>
<c:forEach var="book" items="${books}" varStatus="status">
	<li>${status.first} / ${status.last} : ${status.count}.책 제목 : ${book.title}, 책 가격 : ${book.price}</li>
	<li>${status.current.title} / ${status.current.price}</li>
</c:forEach>
</ul>

<c:forEach var="item" items="${fruits}">
${item}<br>
</c:forEach>

<c:forEach var="num" begin="1" end="10" step="3">
<h2>반복! ${num}</h2>
</c:forEach>

