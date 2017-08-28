<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>登陆界面</title>
		
        <link href="../css/bootstrap.min.css" rel="stylesheet">

		<!-- <script src="../js/jquery-1.12.4.min.js"></script> -->

		<script src="../js/bootstrap.min.js"></script>
		
		<style type="text/css">
			.login{
				margin:auto;
				text-align: center;
				margin-top: 350px;
			}
			.btn{
				
				background-color: limegreen;
				width: 20%;
				border-collapse: 10px;
			}
			
		</style>
		
				
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.min.js"></script>	
		
		
		<script type="text/javascript">
		$(function(){
			$("#formId").validate({
				
				rules:{
					username:{
						required:true,
						minlength:3
					
					},
					password:{
						required:true
						
						
					},
					rpwd:{
						required:true,
						equalTo:"[name=password]"
					}
					
					
				},	
			
			 messages:{
				 username:{
						required:"用户名不能为空",
						minlength:"太短了"
						
					},
					password:{
						required:"密码不能为空"
					   
						
					},
					rpwd:{
						required:"请确认密码",
						equalTo:"密码不匹配"
						
						
					}
				 

			 }
			
			
			
			
			});
		});
		
		
		</script>
		

		
		

	</head>

	<body>
	
		<form action="<c:url value="/admin/login.action"/>" id="formId" >
	<div class="login">
		<img src="${pageContext.request.contextPath }/img/logo.png" style="width:20%;"/><br>
		<input style="width:20%;" class="img-rounded" type="text"  size="3" name="username" placeholder="用户名"  ><br>
		<input type="password" class="img-rounded" style="width:20%;" name="password" placeholder="密码" size="3"/><br>
		<input type="password" class="img-rounded" style="width:20%;" name="rpwd" placeholder="密码" size="3"/><br>
		<input  type="submit" class="btn"  value="登录" >
		 <p style="color: red; font-size: 15px;">${errorMessage }</p> 
	</div>
</form>
	</body>
</html>