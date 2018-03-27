<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
ショップ管理トップメニュー<br/>
<ul>
	<li><a href="<c:url value='/staff/list' />">スタッフ一覧画面へ</a>
	<li><a href="<c:url value='/product/list' />">商品一覧画面へ</a>
	<li><a href="<c:url value='/shop/orderDownload' />">注文ダウンロードへ</a>
	<li><a href="<c:url value='/' />">ろくまる農園トップページへ</a>
	<br/>
	<form action="<c:url value='/staff/logout' />" method="post">
	<sec:csrfInput/>
	<button>ログアウト</button>
	</form>
</ul>
</body>
</html>