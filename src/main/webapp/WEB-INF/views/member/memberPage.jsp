<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberPage</title>
<style type="text/css">
	td{
		border: 1px solid black;
		width: 100px;
	}
</style>
</head>
<body>
	<h1>MY PAGE</h1>
	<table>
		<tr>
			<td>ID</td><td>${member.id}</td>
		</tr>
		<tr>
			<td>NAME</td><td>${member.name}</td>
		</tr>
		<tr>
			<td>AGE</td><td>${member.age}</td>
		</tr>
		<tr>
			<td>IMAGE</td><td><img alt="니사진" src="/ex5/resources/upload/${member.fileName}" style="width:300px"></td>
		</tr>
		
		<c:catch>
		<c:if test="${member.grade == 'student'}">
			<tr>
				<td>PHONE</td><td>${member.phone}</td>
			</tr>
			<tr>
				<td>TID</td><td>${member.tid}</td>
			</tr>
		</c:if>
		</c:catch>
		
		<c:catch>
		<c:if test="${member.grade == 'teacher'}">
			<tr>
				<td>SUBJECT</td><td>${member.subject}</td>
			</tr>
			<tr>
				<td>HIREDATE</td><td>${member.hireDate}</td>
			</tr>
		</c:if>
		</c:catch>
		
	</table>

</body>
</html>