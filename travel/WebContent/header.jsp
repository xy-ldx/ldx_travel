<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 头部 start -->
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>

<script src="js/getParameter.js"></script>
<script>
    $(function () {
        //查询用户信息
        $.get("user/findOne",{},function (data) {
           //{uid:1,name:'李四'}
           var msg = "欢迎回来，"+data.name;
           $("#span_username").html(msg);

       });

       //查询分类数据
        $.get("category/findAll",{},function (data) {
            //[{cid:1,cname:国内游},{},{}]
            var lis = '<li class="nav-active"><a href="index.jsp">首页</a></li>';
            //遍历数组,拼接字符串(<li>)
            for (var i = 0; i < data.length; i++) {
                var li = '<li><a href="route_list.jsp?cid='+data[i].cid+'">'+data[i].cname+'</a></li>';

                lis += li;
                
            }
            

            //拼接收藏排行榜的li,<li><a href="favoriterank.html">收藏排行榜</a></li>
            
            lis+= '<li><a href="favoriterank.html">收藏排行榜</a></li>';

            //将lis字符串，设置到ul的html内容中
            $("#category").html(lis);
        });


        //给搜索按钮绑定单击事件，获取搜索输入框的内容
        $("#search-button").click(function () {
            //线路名称
            var rname = $("#search_input").val();

            //var cid = getParameter("cid");
            // 跳转路径 http://localhost/travel/route_list.html?cid=5，拼接上rname=xxx
            //location.href="http://localhost/travel/route_list.jsp?cid="+cid+"&rname="+rname;
            //location.href="http://localhost/travel/route_list.jsp";
        });
    });

</script>

<header id="header">

        <div class="top_banner">
            <img src="images/top_banner.png" alt="">
        </div>
        
        <div class="shortcut">
            <!-- 未登录状态  -->
            <div class="login_out">
                <a href="login.jsp">登录</a>
                <a href="register.jsp">注册</a>
            </div>
            <!-- 登录状态  -->
            <div class="login">
            	
                <span id="span_username">${user.username}</span>
             <%--    <a href="${pageContext.request.contextPath}/routeServlet" class="collection">我的收藏</a> --%>
                <a href="${pageContext.request.contextPath}/exitServlet">退出登录</a>
            </div>
        </div>
      
        <div class="header_wrap" style="position:relative">
            <div class="topbar" style="position:relative">
                <div class="logo" style="position:relative">
                    <a href="/"><img src="images/logo.png" alt=""></a>
                </div>
                 <form  id="Form1" name="Form1" action="${pageContext.request.contextPath}/rnameSearch" method="post">
                	<div class="search" style="position:relative">
               
                    <input name="rname" id="search_input"  type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off">
                  
                    
                   
              <!--  <a href="route_list.jsp"  id="search-button" class="search-button">搜索</a> -->
                 	<input class="search-button" type="submit" value="搜索"> 
                   
                </div>
                </form>
                <div class="hottel">
                    <div class="hot_pic">
                        <img src="images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-618-9090</p>
                    </div>
                </div>
            </div>
        </div>
       
  <div class="navitem">
        <ul id="category" class="nav">
            <li class="nav-active"><a href="index.jsp">首页</a></li>
            <li><a href="route_list.html">门票</a></li>
            <li><a href="route_list.html">酒店</a></li>
            <li><a href="route_list.html">香港车票</a></li>
            <li><a href="route_list.html">出境游</a></li>
            <li><a href="route_list.html">国内游</a></li>
            <li><a href="route_list.html">港澳游</a></li>
            <li><a href="route_list.html">抱团定制</a></li>
            <li><a href="route_list.html">全球自由行</a></li>
            <li><a href="favoriterank.html">收藏排行榜</a></li>
         
           
        </ul>
        
    </div> 
      <!-- banner start-->
    <section id="banner" >
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="images/banner_1.png" alt="">
                </div>
                <div class="item">
                    <img src="images/banner_2.png" alt="">
                </div>
                <div class="item">
                    <img src="images/banner_3.png" alt="">
                </div> 
               
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
        </div>
    </section>
    <!-- banner end-->
     
     
       
       
       
       
       
       
       
       
    </header>
    <!-- 头部 end -->
     <!-- 首页导航 -->
    
    