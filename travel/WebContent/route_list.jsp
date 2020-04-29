<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>星途旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>

</head>
<body>
<!--引入头部-->
<div id="header"></div>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <p>星途旅行><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul id="route">
                <c:forEach items="${place}" var="place">
                    <li>
                        <div class="img"><img src="${place.rimage}" alt=""></div>
                        <div class="text1">
                            <p>${place.rname}</p>
                            <br/>
                            <p style="margin-left:18px;margin-top:-5px">${place.routeIntroduce}</p>
                        </div>
                        <div class="price">
                            <p class="price_num">
                                <span>&yen;</span>
                                <span>${place.price}</span>
                                <span>起</span>
                            </p>
                            <p><a href="route_detail.jsp">查看详情</a></p>
                        </div>
                    </li>
                    </c:forEach>
                   
                  
                   
                </ul>
                <div class="page_num_inf">
                    <i></i> 共
                    <span id="totalPage">12</span>页<span id="totalCount">132</span>条
                </div>
                <div class="pageNum">
                    <ul id="pageNum">
                        <li><a href="">首页</a></li>
                        <li class="threeword"><a href="#">上一页</a></li>
                        <li class="curPage"><a href="#">1</a></li>
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
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>
                <c:forEach items="${place}" var="place">
                    <li>
                        <div class="left"><img src="${place.rimage}" alt=""></div>
                        <div class="right">
                            <p>${place.rname}</p>
                            <p>网付价<span>&yen;<span>${place.price}</span>起</span>
                            </p>
                        </div>
                    </li>
                 </c:forEach>
                    
                   
                    
                   
                </ul>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<div id="footer"></div>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
</body>

</html>