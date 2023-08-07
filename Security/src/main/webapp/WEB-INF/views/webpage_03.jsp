<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Security</title>
</head>
<body>
	<h2>������ ��ť��Ƽ �±� ����</h2>
	<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin">
	<p> <h3> ������ ���� ȭ���Դϴ�. </h3>
	</sec:authorize>
	
	<c:choose>
		<c:when test="${isAdmin}">
			<p> �α��� ���Դϴ�.
			<p> ��й�ȣ : <sec:authentication property="principal.password" />
				<sec:authentication property="authorities" var="roles" scope="page" />
			<p> ���� :
			<ul>
				<c:forEach var="role" items="${roles }">
					<li>${role }</li>
				</c:forEach>
			</ul>
			<p> ����� : <sec:authentication property="principal.username"/>
			<p> <a href="<c:url value='/exam03' />"> /exam03 ���� �̵� </a>
		</c:when>
		
		<c:otherwise>
			<p> �α��� ���� �ƴմϴ� </p>
			<p> <a href="<c:url value='/admin/tag' />"> /admin/tag�� �̵��ϱ� </a>	
		</c:otherwise>
	</c:choose>
</body>
</html>