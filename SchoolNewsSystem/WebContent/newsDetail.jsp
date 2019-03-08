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
		<script type="text/javascript" src="js/common.js" ></script>
		<!--<link rel="stylesheet" href="css/page.css" />-->
		<title>校园新闻网</title>
		<style type="text/css">
			body{
				background: #f9f9f9;
			}
			.wrapper-content{
				height: 600px;
				width: 60%;
				margin: 5% auto;
				/*background: #FFFFFF;*/
				position: relative;
				/*border: 1px solid red;*/
			}
			.left-wrapper{
				width: 20%;
				height: 100%;
				background: #1B6D85;
				opacity: 0.7;
				float: left;
			}
			.news-wraper-left{
				font-size: 18px;
				font-weight: bold;
				color: #FFFFFF;
				text-align: center;
				padding-top: 10px;
			}
			.news-wrapper-right{
				height: 100%;
				width: 79%;
				/*border: 1px solid red;*/
				float: right;
				background: #FFFFFF
			}
			.AllUl{
				padding-top: 30px;
			}
			.AllUl li{
				height: 40px; 
				width: 100%;
				border-bottom: 1px dotted #eaeaea;
			}
			.news-titles{
				height: 30px; 
				width: 60%;
				display: inline-block;
				/*border: 1px solid yellow;*/
				overflow: hidden;
				text-overflow:ellipsis;
				white-space: nowrap;
			    font-weight: 200;
			    padding-top: 5px;
			    padding-left: 10px;
			    margin-top: 6px;
			}
			.news-times{
				width: 35%;
				height: 30px;
				/*border: 1px solid red;*/
				float: right;
			    font-size: 12px;
			    padding-top: 7px;
			    text-align: right;
			    padding-right: 46px;
				 margin-top: 6px;
			}
			.AllUl li:first-child{
				border-top: 1px dotted #eaeaea;
			}
			.paging{
			width: 500px;
			height: 40px;
			/*border: 1px solid red;*/
		}
		.paging .padeUl{
			padding: 0;
			margin: 0;
		}
		.paging .padeUl li{
			list-style: none;
			float: left;
			display: inline-block;
			width: 40px;
			height: 35px;
			border: 1px solid #999;
			text-align: center;
			padding-top: 5px;
			cursor: pointer;
			margin-left: 5px;
			color: #000000;
		}
		.paging .padeUl li a{
			text-decoration: none;
			padding-top: 5px;
		}.paging .padeUl li:hover{
			color: #0090FF;
		}
			
		</style>
	</head>
	<body>
	<jsp:include page="/showTypeNews"/>
		<span></span>
		<div class="wrapper-content">
			<div class="left-wrapper">
				<ul>
					<li class="news-wraper-left" id="title-detail-content"></li>
				</ul>
			</div>
			<div class="news-wrapper-right">
				<ul class="AllUl">
					<c:forEach items="${typenewes }" var="news">
						<li>
						<label class="news-titles"> <a href="${pageContext.request.contextPath }/showNewsContent?nid=${news.nid}&type=${news.type}">${news.title }</a></label>
						<span class="news-times">${news.date }</span>
					</c:forEach>
					</li>	
				</ul>
				
				
				<!--分页-->
				
				<div class="paging">
					<ul class="padeUl">
						<li><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=${page-1 }&flag=1"><</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=1&flag=1">1</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=2&flag=1">2</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=3&flag=1">3</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=4&flag=1">4</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=5&flag=1">5</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=6&flag=1">6</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=7&flag=1">7</a></li>
						<li class="pages"><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=8&flag=1">8</a></li>
						<li><a href="${pageContext.request.contextPath }/requestType?type=${newsType}&page=${page+1}&flag=1">></a></li>
					</ul>
				</div>
			</div>
			
		</div>
		<script>
			//获取当前url参数
			var ids=GetQueryString('id');
			if(ids==1){
				$('#title-detail-content').text('校内动态')
			}else if(ids==2){
				$('#title-detail-content').text('校园风采')
				
			}else if(ids==3){
				$('#title-detail-content').text('校园政策')
				
			}else{
				$('#title-detail-content').text('生活常识')
				
			}
		</script>
	</body>
</html>