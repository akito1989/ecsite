<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
<h3>スタッフログイン</h3>
<c:if test="${param.containsKey('error')}">
	<span style="color:red;">
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
	</span>
</c:if>
<c:url var="loginUrl" value="./login"/>
<form:form action="${loginUrl}">
	<table>
		<tr>
			<td><label for="username">ユーザーコード</label></td>
			<td><input type="text" id="username" name="username"></td>
		</tr>
		<tr>
			<td><label for="password">パスワード</label></td>
			<td><input type="password" id="password" name="password"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><button>ログイン</button></td>
		</tr>
	</table>
</form:form>
</div>
<br/>
<a href="<c:url value="/"/>">ろくまる農園トップへ</a>
</body>
</html>