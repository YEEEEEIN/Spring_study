<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 정보</h3>
	<p>아이디 : ${member.id }
	<p>비밀번호 : ${member.password }
	<p>거주지 : ${member.city }
	<p>성별 : ${member.sex }
	<p>취미 : <c:forEach items="${member.hobby }" var="hobby" >
				[<c:out value="${hobby }"/>]
				</c:forEach>
</body>
</html>