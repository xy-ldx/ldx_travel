<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>
<style type="text/css">
*{ margin:0px; padding:0px;}
 #menu{ background-color:#ffc900; width:1318px; height:40px; margin:0 auto;}
 ul{ list-style:none;}
 ul li{ line-height:40px; text-align:center; position:relative; float:left;}
 li  a{ text-decoration:none; color:#000; display:block; width:90px;}
 a:hover{ color:red;text-decoration:none;}
 ul li ul li{ float:none;margin-top:2px; background-color:#eee; } 
 ul li ul{width:90px; position:absolute;z-index:1000;display:none;  }
 ul li:hover ul{display:block;}
 .btn{background:#ffc900}
</style>

</head>
 
<body>
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
                        <p class="hot_num">400-842-6420</p>
                    </div>
                </div>
            </div>
        </div>
<div id="menu">
<ul>
  <li><a href="#">首页</a></li>
  <li><a href="#">门票</a>
    <ul>
     <li><a href="#">火车票</a>   
     <li><a href="#">机票</a>   
    </ul>
  </li>
  <li><a href="#">酒店</a>
    <ul>
      <li><a href="#">三星级酒店</a></li>
      <li><a href="#">四星级酒店</a></li>
      <li><a href="#">五星级酒店</a></li>
    </ul>
  </li>
  <li><a href="#">国内游</a>
  	 <ul>
      <li><a href="#">自驾游</a></li>
      <li><a href="#">组团游</a></li>
    </ul>
    </li>
  <li><a href="#">出境游</a></li>
  <li><a href="#">驴友社区</a></li>
</ul>
<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/rnameSearch" method="post">
					<div class="form-group" style="position:relative;margin-top:-14px;">
						<input  id="search" type="text" class="form-control" placeholder="请输入路线名称" onkeyup="searchWord(this)"  name="rname" >
						<div id="showDiv" style="position:absolute;z-index:1000;background:#fff; width:400px;border:1px solid #ccc;">
							
						</div>
					</div>
					<input  type="submit" value="搜索" class="btn"> 
					<!-- <button type="submit" class="btn btn-default">Submit</button> -->
				</form>
				<!--完成ajax异步搜索 -->
				<script type="text/javascript">
				
					function overFn(obj){
						$(obj).css("background","#fb9f93");
					}
					function outFn(obj){
						$(obj).css("background","#fff");
					}
					
					function clickFn(obj){
						$("#search").val($(obj).html());
						$("#showDiv").css("display","none");
					}
					
				
					function searchWord(obj){
						//1、获得输入框的输入的内容
						var word = $(obj).val();
						//2、根据输入框的内容去数据库中模糊查询---List<Product>
						var content = "";
						$.post(
							"${pageContext.request.contextPath}/searchWord",
							{"word":word},
							function(data){
								//3、将返回的商品的名称 现在showDiv中
								//[{"pid":"1","pname":"小米 4c 官方版","market_price":8999.0,"shop_price":8999.0,"pimage":"products/1/c_0033.jpg","pdate":"2016-08-14","is_hot":1,"pdesc":"小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待 官方好好","pflag":0,"cid":"1"}]
								
								if(data.length>0){
									for(var i=0;i<data.length;i++){
										content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
									}
									$("#showDiv").html(content);
									$("#showDiv").css("display","block");
								}
								
							},
							"json"
						);
						
					}
				</script>
</div> 
<!-- 轮播图 -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- 轮播图的中的小点 -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- 轮播图的轮播图片 -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="images/banner_1.png">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="images/banner_2.png">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="images/banner_3.png">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
					</div>

					<!-- 上一张 下一张按钮 -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			</header>
			</body>
</html>