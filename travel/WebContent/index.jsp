<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
<style type="text/css">
a{
text-decoration: none;/*去掉所有连接默认修饰*/
		}
</style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>星途旅游网</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.3.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script>
			function init(){
				
			}
			$(function(){
				//1.书写显示广告图片的定时操作
				time = setInterval("showAd()",2000);
			});
			
			//2.书写显示广告图片的函数
			function showAd(){
				//3.获取广告图片，并让其显示
				//$("#img2").show(1000);
				//$("#img2").slideDown(5000);
				$("#img2").fadeIn(4000);
				//4.清除显示图片定时操作
				clearInterval(time);
				//5.设置隐藏图片的定时操作
				time = setInterval("hiddenAd()",3000);
			}
			
			function hiddenAd(){
				//6.获取广告图片，并让其隐藏
				//$("#img2").hide();
				//$("#img2").slideUp(5000);
				$("#img2").fadeOut(6000);
				//7.清除隐藏图片的定时操作
				clearInterval(time);
			}
		</script>
</head>
<body onload="init()">
	<!--引入头部-->
    <div id="header">
      <!--定时弹出广告图片位置-->
			
    <jsp:include page="header1.jsp"></jsp:include>
     <img src="images/ad.jpg" width="100%" style="display: none" id="img2"/>
    </div>
    <!-- 旅游 start-->
    <section id="content">
         <!-- 星途精选start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_5.jpg" alt="">
                    <span>星途精选</span>
                </div>
                <!-- Nav tabs -->
                <ul class="jx_tabs" role="tablist">
                    <li role="presentation" class="active">
                        <span></span>
                        <a href="#popularity" aria-controls="popularity" role="tab" data-toggle="tab">人气旅游</a>
                    </li>
                    <li role="presentation">
                        <span></span>
                        <a href="#newest" aria-controls="newest" role="tab" data-toggle="tab">最新旅游</a>
                    </li>
                    <li role="presentation">
                        <span></span>
                        <a href="#theme" aria-controls="theme" role="tab" data-toggle="tab">主题旅游</a>
                    </li>
                </ul>
            </div>
            <div class="jx_content">
                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="popularity">
                        <div class="row">
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/slide-beijing.jpg" alt="">
                                    <div class="has_border">
                                        <h3>首都北京2天1晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>1999</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/slide-shanghai.jpg" alt="">
                                    <div class="has_border">
                                        <h3>天堂上海3天2晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>899</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/slide-xian.jpg" alt="">
                                    <div class="has_border">
                                        <h3>古城西安5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>1789</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/slide-xianggang.jpg" alt="">
                                    <div class="has_border">
                                        <h3>豪华香港3天2晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>4289</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="newest">
                        <div class="row">
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/slide-nangjing.jpg" alt="">
                                    <div class="has_border">
                                        <h3>南京3天2晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/slide-sanya.jpg" alt="">
                                    <div class="has_border">
                                        <h3>三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>3889</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/w5.jpg" alt="">
                                    <div class="has_border">
                                        <h3>西伯利亚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>2889</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/w3.jpg" alt="">
                                    <div class="has_border">
                                        <h3>波兰的海3天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>4889</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="theme">
                        <div class="row">
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/w7.jpg" alt="">
                                    <div class="has_border">
                                        <h3>旧金山3天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>3888</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/w2.jpg" alt="">
                                    <div class="has_border">
                                        <h3>罗马5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>7889</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/w6.jpg" alt="">
                                    <div class="has_border">
                                        <h3>印度2天1晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>789</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/w8.jpg" alt="">
                                    <div class="has_border">
                                        <h3>巴黎4天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                        <div class="price">网付价<em>￥</em><strong>5889</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 星途精选end-->
        <!-- 国内游 start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_6.jpg" alt="">
                    <span>国内游</span>
                </div>
            </div>
            <div class="heima_gn">
                <div class="guonei_l">
                    <img src="images/guonei_1.jpg" alt="">
                </div>
                <div class="guone_r">
                    <div class="row">
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/slide-xiamen.jpg" alt="">
								<div class="has_border">
									<h3>厦门5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>3889</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/slide-qingdao.jpg" alt="">
								<div class="has_border">
									<h3>青岛2天2晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>1888</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/slide-guiling.jpg" alt="">
								<div class="has_border">
									<h3>桂林3天2晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/slide-fenghuang.jpg" alt="">
								<div class="has_border">
									<h3>凤凰3天3晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>2889</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/slide-lijiang.jpg" alt="">
								<div class="has_border">
									<h3>丽江4天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>2666</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/slide-hangzhou.jpg" alt="">
								<div class="has_border">
									<h3>杭州2天1晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>989</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 国内游 end-->
        <!-- 境外游 start-->
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_7.jpg" alt="">
                    <span>境外游</span>
                </div>
            </div>
            <div class="heima_gn">
                <div class="guonei_l">
                    <img src="images/jingwai_1.jpg" alt="">
                </div>
                <div class="guone_r">
                    <div class="row">
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/p1.jpg" alt="">
								<div class="has_border">
									<h3>东京5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>4889</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/p2.jpg" alt="">
								<div class="has_border">
									<h3>新德里5天5晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>4589</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;p">
								<img src="images/p3.jpg" alt="">
								<div class="has_border">
									<h3>巴厘岛5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>1289</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
								<img src="images/p4.jpg" alt="">
								<div class="has_border">
									<h3>京都3天3晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>3689</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;">
									<img src="images/p5.jpg" alt="">
								<div class="has_border">
									<h3>曼德勒4天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>2879</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                        <div class="col-md-4">
                            <a href="javascript:;p">
								<img src="images/p6.jpg" alt="">
								<div class="has_border">
									<h3>加勒2天2晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
									<div class="price">网付价<em>￥</em><strong>1889</strong><em>起</em></div>									
								</div>
							</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 境外游 end-->
    </section>
    <!-- 旅游 end-->
   <!--导入底部-->
    <div id="footer">
    <jsp:include page="footer.jsp"></jsp:include>
    </div>

</body>
</html>
