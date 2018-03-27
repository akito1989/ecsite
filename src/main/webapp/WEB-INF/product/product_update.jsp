<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
商品修正<br/>
<br/>
商品コード<br/>
<c:out value="${productForm.code}"/>
<br/>
<form:form modelAttribute="productForm" action="/firstapp/product/update" enctype="multipart/form-data">
<form:input type="hidden" path="code" value="${productForm.code}"/><br/>
商品名<br/>
<form:input path="name" value="${productForm.name}"/><br/>
価格を入力してください<br/>
<form:input path="price" value="${productForm.price}"/><br/>
<img src="http://localhost:8080/firstapp/product/edit/${productForm.code}"/>
<br/>
<div>画像を選択して下さい</div>
<div>
	<form:input type="file" path="gazou"/><br/>
</div>
<form:button>送信</form:button><br/>
</form:form>
<br/>
<a href="<c:url value="/product/list"/>">戻る</a>
</body>
</html>