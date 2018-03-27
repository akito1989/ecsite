<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
スタッフ情報参照<br/>
<c:forEach var="staff" items="${staffList}"><br/>
	スタッフコード<br/>
	<c:out value="${staff.code}"/><br/>
	スタッフ名<br/>
	<c:out value="${staff.name}"/><br/>
</c:forEach>
<a href="<c:url value="/staff/list"/>">戻る</a>
</body>
</html>