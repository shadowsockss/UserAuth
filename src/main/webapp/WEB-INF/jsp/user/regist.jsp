<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImg(){
		document.getElementById("myImg").src='${pageContext.request.contextPath}/servlet/CheckCodeServlet?' +
				new Date().getTime();
	}
	function validataForm(){
		var username = document.getElementById("username").value;
		if(username == ""){
			alert("用户名不能为空！");
			return false;
		}
		
		var password = document.getElementById("password").value;
		if(password == ""){
			alert("密码不能为空!");
			return false;
		}
		
		var repassword = document.getElementById("repassword").value;
		if(password != repassword){
			alert("两次密码不一致！");
			return false;
		}
		
		var email = document.getElementById("email").value;
		if(email.match("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")==null){
			alert("哥们儿,邮箱地址非法");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/RegistServlet"  onsubmit="return validataForm();"   method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="passoword" name="password" id="password"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="repassword" id="repassword"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td>
				<input type="text" name="checkcode">
				<img src="${pageContext.request.contextPath }/servlet/CheckCodeServlet" 
				onclick="changeImg();" style="cursor: pointer;" id="myImg"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
</body>
</html>