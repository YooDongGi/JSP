<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>sumCalculation</title>
</head>
<body>
	<h2>ㅁ 에서 ㅁ 까지의 합</h2>
	<form action="${pageContext.request.contextPath }/sumCalculation" method="post">
		<input type="text" name = "start"> 에서 <input type="text" name = "end"> 까지의 합 구하기
		<input type="submit" value = "결과">
	</form>
	<br><br>
	<h2>곱하기</h2>
	<form action="${pageContext.request.contextPath }/mulCalculation" method="post">
		<input type="text" name="param1"> * <input type="text" name="param2"> 
		<input type="submit" value = "결과">
	</form>
</body>
</html>