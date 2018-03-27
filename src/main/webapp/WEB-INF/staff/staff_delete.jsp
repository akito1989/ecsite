<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
スタッフ削除画面</br>
<br/>
<form:form modelAttribute="staffForm" action="edit/delete">
<form:input type="hidden" path="code" value="${staffForm.getCode()}"/>
スタッフコード：</br>
<c:out value="${staffForm.getCode()}"/></br>
スタッフ名：</br>
<c:out value="${staffForm.getName()}"/></br>
<br/>
消去しますか？
<form:button>消去</form:button>
</form:form>
</body>
</html>