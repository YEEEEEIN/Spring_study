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
	<h3>ȸ�� ����</h3>
	<p>���̵� : ${member.id }
	<p>��й�ȣ : ${member.password }
	<p>������ : ${member.city }
	<p>���� : ${member.sex }
	<p>��� : <c:forEach items="${member.hobby }" var="hobby" >
				[<c:out value="${hobby }"/>]
				</c:forEach>
</body>
</html>