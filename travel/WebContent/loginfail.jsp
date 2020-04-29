<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var time = 5;
		var secondEle = document.getElementById("second");
		var timer = setInterval(function(){
			secondEle.innerHTML = time;
			time--;
			if(time==0){
				clearInterval(timer);
				location.href="login.jsp";
			}
				
		},1000);
	}
</script>
</head>
<body>
	可惜啦，登录失败，请重新再来！<span style="color:red" id="second">5</span>秒钟后跳转，如不跳转点击<a href="login.jsp">这里</a>!
</body>
</html>