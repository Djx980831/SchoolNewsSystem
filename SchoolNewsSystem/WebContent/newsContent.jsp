<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/reset.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
		<!--<script type="text/javascript" src="js/bootstrap.js" ></script>-->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/common.js" ></script>
		<title>详情</title>
		<style type="text/css">
			body{
				background: #F9F9F9;
			}
			.news-content{
				width: 70%;
				height: 650px;
				margin: 0 auto;
				margin-top: 60px;
				position: relative;
				/*border: 1px solid red;*/
			}
			.content-title{
				height: 110px;
				width: 100%;
				/*border: 1px solid yellow;*/
			}
			#news-titles{
				height: 50px;
				text-align: center;
				/*border: 1px solid red;*/
			}
			.sourec-time{
				text-align: center;
			}
			.spans{
				font-size: 12px;
			}
			.source{
				margin-right: 50px;
			}
			.news-detail{
				height: 520px;
				width: 100%;
				background: #FFFFFF;
				padding: 20px;
				overflow-x: auto;
				/*border: 1px solid #999999;*/
			}
		</style>
	</head>
	<body>
		<div class="news-content">
			<div class="content-title">
				<h3 id="news-titles">${news1.title }</h3>
				<p class="sourec-time">
					<span class="spans source">来源：${news1.source }</span><span class="spans times">发布时间：${news1.date }</span>
				</p>
			</div>
			<div class="news-detail">
				　${news1.content }
			</div>
		</div>
	</body>
</html>