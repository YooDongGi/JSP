<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		td {
			width:130px;	
			height:50px;	
			text-align:center;	
		}
	</style>
</head>
<body>
	<h3>timesTable.jsp 의 표현식, 스크립틀릿 ==> EL, JSTL로 변경</h3>
	
	<table border = "1">
		<c:forEach begin="1" end="9" var="i">
			<tr>
				<c:forEach begin="2" end="9" var="j">
					<td>${j } * ${i } = ${j*i }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>