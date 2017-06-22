<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>joinForm</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
		
		$("#teacherForm").hide();
		
		$(".g").each(function(index){
			
			$(this).click(function(){
				var grade = $(this).val();
				alert(grade);
				if(grade=="teacher"){
					$("#teacherForm").show();
					$("#studentForm").hide();
				}else if(grade=="student"){
					$("#studentForm").show();
					$("#teacherForm").hide();
				}
			});
			
		});
		
		$("#btn").click(function(){
			
			var path;
			$(".g").each(function(index){
				//alert($(this).prop("checked") + " i = " + index);
				if($(this).prop("checked") == true){
					path = $(this).val()+"Join";
				}
			});

			$("#frm").attr("action",path);
			$("#frm").submit();
			
		});
		
		
	});	

</script>

</head>
<body>
	
	<form action="" id="frm" method="POST" enctype="multipart/form-data">
		<div>
			STUDENT<input type="radio" class="g" name="grade" value="student" checked="checked" >
			TEACHER<input type="radio" class="g" name="grade" value="teacher">
		</div>
		
		<!-- 공통 입력 -->
		<div>
			ID : <input type="text" name="id"> <br/>
			PW : <input type="password" name="pw"> <br/>
			NAME : <input type="text" name="name"> <br/>
			AGE : <input type="number" name="age"> <br/>
			FILE: <input type="file" name="f1">	<br/>
			<!-- 
			IMAGE : <input type="text" name="fileName"> <br/>
			IMAGE : <input type="text" name="oriName"> <br/>
			 -->
		</div>
		
		<!-- Student -->
		<div id="studentForm">
			<br/>
			PHONE : <input type="text" name="phone"> <br/>
			TID : <input type="text" name="tid"> <br/>
		</div>
		
		<!-- Teacher -->
		<div id="teacherForm">
			<br/>
			SUBJECT : <input type="text" name="subject"> <br/>
			HIREDATE : <input type="date" name="hireDate"> <br/>
		</div>
		
		
		<input type="button" value="JOIN" id="btn">
	</form>


</body>
</html>