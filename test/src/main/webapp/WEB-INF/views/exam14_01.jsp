<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>ȸ�� ����</h3>
<form:form modelAttribute="member" method="post">
	<p>���̵� : <form:input path="id" name="id" />
	<p>��й�ȣ : <form:password path="password" />
	<p>���ø� : <form:select path="city" >
		<form:option value="�����">�����</form:option>
		<form:option value="��⵵">��⵵</form:option>
		<form:option value="��õ��">��õ��</form:option>
		<form:option value="������">������</form:option>
		<form:option value="���">���</form:option>
		<form:option value="����">����</form:option>
		<form:option value="��û��">��û��</form:option>
		</form:select>
	<p>���� : <form:radiobutton path="sex" value="����" />����
		<form:radiobutton path="sex" value="����" />����
	<p>��� : ����<form:checkbox path="hobby" value="����" />
			��ȭ��û<form:checkbox path="hobby" value="��ȭ��û" />
			�<form:checkbox path="hobby" value="�" />
	<p><input type="submit" value="�����ϱ�" /> <input type="reset" value="�ٽþ���" />
</form:form>
</body>
</html>