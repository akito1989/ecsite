<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
商品削除画面</br>
<br/>
<form:form modelAttribute="productForm" action="edit/delete">
<form:input type="hidden" path="code" value="${productForm.getCode()}"/>
商品コード：</br>
<c:out value="${productForm.getCode()}"/></br>
商品名：</br>
<c:out value="${productForm.getName()}"/></br>
<br/>
消去しますか？
<form:button>消去</form:button><br/>
<a href="<c:url value="/product/list"/>">戻る</a>
</form:form>
</body>
</html>