<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
		
		$("#btn").click(function(){
			
			var path;
			$(".g").each(function(index){
				//alert($(this).prop("checked") + " i = " + index);
				if($(this).prop("checked") == true){
					path = $(this).val()+"Login";
				}
			});

			$("#frm").attr("action",path);
			$("#frm").submit();
			
		});
		
		
	});	

</script>
</head>
<body>
	<form action="" method="POST" id="frm">
		<p>ID: <input type="text" name="id"></p>
		<p>PW: <input type="password" name="pw"></p>
		<div>
			<p>STUDENT<input type="radio" class="g" name="grade" value="student" checked="checked" ></p>
			<p>TEACHER<input type="radio" class="g" name="grade" value="teacher"></p>
		</div>
		
		<input type="button" value="LOGIN" id="btn">
	</form>

</body>
</html>