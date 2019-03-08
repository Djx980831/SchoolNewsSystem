<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/reset.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
		<!--<script type="text/javascript" src="js/bootstrap.js" ></script>-->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<title>校园新闻网</title>
		
		<style>
			.header{
				width: 100%;
				height: 20px;
				/*border: 1px solid yellow;*/
			}
			.banner-wrapper{
				height: 400px;
				width: 100%;
				/*border: 1px solid red;*/
				padding: 0;
				margin: 0;
				overflow: hidden;
			}
			.banner-wrapper li{
				list-style: none;
				width: 100%;
				height: 400px;
				padding: 0;
				margin: 0;
				text-align: center;
				float: left;
			}
			.li1{
				/*width: 1519px;*/
    			float: left;
			}
			.news-content{
				height: 400px;
				width: 84%;
				margin: 0 auto;
				position: relative;
				display: flex;
				flex: 1;
				/*border: 1px solid red;*/
			}
			.content{
				width: 24%;
				height: 400px;
				/*border: 1px solid yellow;*/
			}
			.title-news{
				padding-left: 20px;
				text-align: center;
			}
			.more-news{
				float: right;
				margin-right: 20px;
				text-decoration: none;
				color: #FFFFFF;
				height: 30px;
				width: 50px;
				background: #999999;
				border-radius: 5px;
			    padding: 6px 0 0 10px;
			}
			.news-content-title{
				height: 300px;
				width: 100%;
			    margin-top: 69px;
				/*border: 1px solid red;*/
			}
			.news-content-title li{
				width: 100%;
				height: 30px;
				overflow: hidden;
				text-overflow:ellipsis;
				white-space: nowrap;
			    line-height: 2.5;
		        padding-left: 5px;
		        color: #000000;
				
			}
			.news-content-title li a{
				color: #000000;
			}
		</style>
	</head>
	<body>
		<div class="header"></div>
		<div class="banner-wrapper">
			<ul id="imgUl">
				<li class="listL li1" id="test" style="background: url(img/127.jpg);"></li>
			</ul>
		</div>
		<div class="news-content">
			<div class="content">
				<p><h4 class="title-news">校内动态</h3><a href="${pageContext.request.contextPath }/newsDetail.jsp?type=1" class="more-news">更多</a></p>
				<ul class="news-content-title">
				<jsp:include page="/showType1News?type=1"/>
					<c:forEach items="${type1newes }" var="news">
						<li><a href="${pageContext.request.contextPath }/showNewsContent?nid=${news.nid}&type=1">${news.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="content">
				<p><h4 class="title-news">校园风采</h4><a h href="${pageContext.request.contextPath }/newsDetail.jsp?type=2" class="more-news">更多</a></p>
				<ul class="news-content-title">
				<jsp:include page="showType2News?type=2"/>
					<c:forEach items="${type2newes }" var="news">
						<li><a href="${pageContext.request.contextPath }/showNewsContent?nid=${news.nid}&type=${news.type}">${news.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="content">
				<p><h4 class="title-news">校园政策</h4><a  href="${pageContext.request.contextPath }/newsDetail.jsp?type=3" class="more-news">更多</a></p>
				<ul class="news-content-title">
				<jsp:include page="showType3News?type=3"/>
					<c:forEach items="${type3newes }" var="news">
						<li><a href="${pageContext.request.contextPath }/showNewsContent?nid=${news.nid}&type=${news.type}">${news.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="content">
				<p><h4 class="title-news">生活常识</h4><a  href="${pageContext.request.contextPath }/newsDetail.jsp?type=4" class="more-news">更多</a></p>
				<ul class="news-content-title">
				<jsp:include page="showType4News?type=4"/>
					<c:forEach items="${type4newes }" var="news">
						<li><a href="${pageContext.request.contextPath }/showNewsContent?nid=${news.nid}&type=${news.type}">${news.title }</a></li>
					</c:forEach>	
				</ul>
			</div>
			
		</div>
	</body>
	<script>
		/*轮播图*/
		var listImg=['img/127.jpg','img/170.jpg','img/546.jpg']
		setInterval(function(){
			listImg.push(listImg[0]);
			listImg.shift(listImg[0])
			$('#imgUl').html('<li class="listL li1" id="test" style="background: url('+listImg[0]+');"></li>')
		},5000);
		
		/**/
		
		
		
	</script>
</html>