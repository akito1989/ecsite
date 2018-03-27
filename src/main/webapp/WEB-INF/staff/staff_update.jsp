<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
スタッフ修正<br/>
<br/>
スタッフコード<br/>
<c:out value="${staffForm.code}"/>
<br/>
<form:form modelAttribute="staffAddForm" action="/firstapp/staff/update">
<form:input type="hidden" path="code" value="${staffForm.code}"/><br/>
スタッフ名<br/>
<form:input path="name" value="${staffForm.name}"/><br/>
パスワードを入力してください<br/>
<form:input type="password" path="password" value=""/><br/>
もう一度パスワードを入力してください<br/>
<form:input type="password" path="password2" value=""/><br/>
<form:button>送信</form:button>
</form:form>
</body>
</html>