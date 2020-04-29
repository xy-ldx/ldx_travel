<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>星途旅游网-登录</title>  
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
      <!--导入angularJS文件-->
    <!--<script src="js/angular.min.js"></script>-->
	<!--导入jquery-->
	<script src="js/jquery-3.3.1.js"></script>

	
</head>

<body>
<!--引入头部-->
<div id="header"></div>
    <!-- 头部 end -->
    <section id="login_wrap">
        <div class="fullscreen-bg" style="background: url(images/login_bg.png);height: 532px;">
        	
        </div>
        <div class="login-box">
        	<div class="title" align="center">

        		<span>欢迎登录星途旅游账户</span>
        	</div>
        	<div class="login_inner">
				
				<!--登录错误提示消息-->
        		<div style="color:red"><%=request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo")%></div>
				<form id="loginForm" action="${pageContext.request.contextPath}/loginServlet" method="post" accept-charset="utf-8">
        			<input type="hidden" name="action" value="login"/>
					<input name="username" type="text" placeholder="请输入账号" autocomplete="off">
        			<input name="password" type="password" placeholder="请输入密码" autocomplete="off">
        			<div class="verify">
					<input name="checkCode" type="text" placeholder="请输入验证码" autocomplete="off">
					<span><img src="checkCode" alt="" onclick="changeCheckCode(this)"></span>
					<script type="text/javascript">
						//图片点击事件
						function changeCheckCode(img) {
							img.src="checkCode?"+new Date().getTime();
						}
					</script>
			</div>
			<br/>
			<div class="submit_btn">
			<!-- <a href="${pageContext.request.contextPath}/loginServlet"><button type="button">登录</button></a> -->
        				
        					<input type="submit" value="登录" style="height:45px;background-color:#ffc900">
        				<div class="auto_login">
        					<input type="checkbox" name="autoLogin" class="checkbox" value="autoLogin">
        					<span>自动登录</span>
        				</div>        				
        			</div>        			       		
        		</form>
        		<div class="reg">没有账户？<a href="register.jsp">立即注册</a></div>
        	</div>
        </div>
    </section>
    <!--引入尾部-->
    <div id="footer"></div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
</body>

</html>