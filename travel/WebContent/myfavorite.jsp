<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>星途旅游网-我的浏览</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" href="css/index.css">
       <style>
           .tab-content .row>div {
            margin-top: 16px;
           } 
           .tab-content {
            margin-bottom: 36px;
           }
       </style>
       <script src="js/jquery-3.3.1.js"></script>
    </head>
    <body>
    <!--引入头部-->
    <div id="header"></div>
         <!-- 排行榜 start-->
        <section id="content">            
            <section class="hemai_jx">
                <div class="jx_top">
                    <div class="jx_tit">
                        <img src="images/icon_5.jpg" alt="">
                        <span>我的浏览</span>
                    </div>                    
                </div>
                <div class="jx_content">
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
                          
                            
                            <c:forEach items="${pageBean.routeList}" var="route">
                            
                            
                                <div class="col-md-3">
                                    <a href="${pageContext.request.contextPath }/routeImg?id=${route.rid}">
                                        <img src="${pageContext.request.contextPath }/${route.rimage}" alt="">
                                        <div class="has_border">
                                            <h3>${route.routeIntroduce}</h3>
                                            <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                        </div>
                                    </a>
                                </div>
                                
                           </c:forEach>     

                                
                               



                               

                               

                               



                               

                                
                            </div>
                        </div>                       
                    </div>
                </div>
                <div class="pageNum">
                  <!--   <ul>
                        <li><a href="">首页</a></li>
                        <li class="threeword"><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="#">8</a></li>
                        <li><a href="#">9</a></li>
                        <li><a href="#">10</a></li>
                        <li class="threeword"><a href="javascript:;">下一页</a></li>
                        <li class="threeword"><a href="javascript:;">末页</a></li>
                    </ul> --> 
                    
            <ul class="pagination" style="text-align: center; margin-top: 10px;">
			<!-- 上一页 -->
			<!-- 判断当前页是否是第一页 -->
			<c:if test="${pageBean.currentPage==1 }">
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=1 }">
				<li>
					<a href="${pageContext.request.contextPath }/routeList?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>	
			
			
			
		
			<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
				<!-- 判断当前页 -->
				<c:if test="${pageBean.currentPage==page }">
					<li class="active"><a href="javascript:void(0);">${page}</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage!=page }">
					<li><a href="${pageContext.request.contextPath }/routeList?currentPage=${page}">${page}</a></li>
				</c:if>
			
			</c:forEach>
			
			<!-- 判断当前页是否是最后一页 -->
			<c:if test="${pageBean.currentPage==pageBean.totalPage }">
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
				<li>
					<a href="${pageContext.request.contextPath }/routeList?currentPage=${pageBean.currentPage+1}" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
		
		</ul>
                </div>
            </section>                      
        </section>
        <!-- 排行榜 end-->
    	
         <!--引入尾部-->
    	<div id="footer"></div>
        <!--导入布局js，共享header和footer-->
        <script type="text/javascript" src="js/include.js"></script>
    </body>
</html>