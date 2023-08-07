<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Security</title>
</head>
<body>
	<h2>������ ��ť��Ƽ �±� ����</h2>
	<sec:authorize access="hasRole('ROLE_MANAGER')" var="isAdmin">
	<p> <h3> �Ŵ��� ���� ȭ���Դϴ�. </h3>
	</sec:authorize>
	
	<c:choose>
		<c:when test="${isAdmin}">
			<p> ROLE_ �� �Դϴ�. </p>
			<p> <a href="<c:url value='/exam02/' />"> exam02�� �̵��ϱ� </a>
		</c:when>
		<c:otherwise>
			<p> �α��� ���� �ƴմϴ� </p>
			<p> <a href="<c:url value='/manger/tag' />"> /manger/tag�� �̵��ϱ� </a>	
		</c:otherwise>
	</c:choose>
</body>
</html>