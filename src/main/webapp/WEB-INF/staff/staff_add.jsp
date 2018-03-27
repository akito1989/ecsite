<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ろくまる農園</title>
</head>
<body>
スタッフ追加<br/>
	<form:form modelAttribute="staffAddForm" action="add">
	<div>スタッフ名を入力して下さい</div>
	<div>
		<form:input type="text" path="name"/>
        <form:errors path="name" /><br>
	</div>
	<div>パスワードを入力して下さい</div>
	<div>
		<form:input type="password" path="password"/>
		<form:errors path="password"/>
        <c:out value="${checkResult.password}"/>
	</div>
	<div>もう一度パスワードを入力して下さい</div>
	<div>
		<form:input type="password" path="password2"/>
		<form:errors path="password2"/>
        <c:out value="${checkResult.password2}"/>
	</div>

	<div>
		<input type="button" onclick="history.back()" value="戻る">
		<form:button>送信</form:button>
	</div>
	</form:form>
</body>
</html>