<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		/* 	if('${member.grade}' == 'student'){
			$("#myPage").prop("href","./member/student/memberPage");
		}else{
			$("#myPage").prop("href","./member/teacher/memberPage");
		} */
	});
</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${member eq null }">
	<a href="./member/memberJoin">회원가입</a>
	<a href="./member/memberLogin">로그인</a>
</c:if>

<c:if test="${member ne null }">
	<a href="./member/memberLogout">로그아웃</a>
	<a href="./member/memberPage" id="myPage">MyPAGE</a>
</c:if>


</body>
</html>
