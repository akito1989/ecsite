<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ろくまる農園</title>
</head>
<body>
商品追加<br/>
	<form:form modelAttribute="productForm" action="add" enctype="multipart/form-data">
	<div>商品名を入力して下さい</div>
	<div>
		<form:input type="text" path="name" label="商品名"/><br/>
        <form:errors path="name" /><br/>
	</div>
	<div>価格を入力して下さい</div>
	<div>
		<form:input type="text" path="price"/><br/>
		<form:errors path="price"/>
        <c:out value="${checkResult.price}"/>
	</div>
	<br/>
	<div>画像を選択して下さい</div>
	<div>
		<form:input type="file" path="gazou"/><br/>
	</div>
	<div>
		<br/>
		<input type="button" onclick="history.back()" value="戻る">
		<form:button>送信</form:button>
	</div>
	</form:form>
</body>
</html>