<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Notice Update Page </h1>
	<form action="noticeUpdate" method="post">
		<input type="hidden" name="num" value="${noticeDTO.num}">
		<p>WRITER: <input type="text" name="writer" value="${noticeDTO.writer}" readonly="readonly"></p>
		<p>TITLE: <input type="text" name="title" value="${noticeDTO.title}"></p>
		<p>CONTENTS: <input type="text" name="contents" value="${noticeDTO.contents}"></p>
		<button>MOD</button>
	</form>
</body>
</html>