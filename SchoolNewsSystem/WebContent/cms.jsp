<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/reset.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
		<!--<script type="text/javascript" src="js/bootstrap.js" ></script>-->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<script src="http://cdn.bootcss.com/tinymce/4.4.3/tinymce.min.js"></script>
		<script type="text/javascript">
		
		//编辑新闻
		function editNews(nid){
		
			//获取news的title,source,type,date,content
			var loadNews=document.getElementById(nid);
			var newsTitle=loadNews.getAttribute("newsTitle");
			var newsSource=loadNews.getAttribute("newsSource");
			var newsType=loadNews.getAttribute("newsType");
			var newsDate=loadNews.getAttribute("newsDate");
			var newsContent=loadNews.getAttribute("newsContent");
			
			type=newsType;

			switch (newsDate) {
			case 1:
				newsType='校园动态';
				break;
			case 2:
				newsType='校园风采';
				break;
			case 3:
				newsType='校园政策';
				break;
			default:
				newsType='生活常识';
				break;
			}
			
			//将news的title,source,type,date,content展示出来
			document.getElementById("editNewsTitle").value=newsTitle;
			document.getElementById("editNewsSource").value=newsSource;
			document.getElementById("editNewsType").selectedIndex=type-1;
			document.getElementById("editNewsContent").value=newsContent;
			
			//为id为nid的文本框赋值
			document.getElementById("nid").value=nid;
			
		}
		
		//加载新闻
		function loadNews(nid){
		
			//获取news的title,source,type,date,content
			var loadNews=document.getElementById(nid);
			var newsTitle=loadNews.getAttribute("newsTitle");
			var newsSource=loadNews.getAttribute("newsSource");
			var newsType=loadNews.getAttribute("newsType");
			var newsDate=loadNews.getAttribute("newsDate");
			var newsContent=loadNews.getAttribute("newsContent");
			

			switch (newsDate) {
			case 1:
				newsType='校园动态';
				break;
			case 2:
				newsType='校园风采';
				break;
			case 3:
				newsType='校园政策';
				break;
			default:
				newsType='生活常识';
				break;
			}
			
			//将news的title,source,type,date,content展示出来
			document.getElementById("showNewsTitle").innerText=newsTitle;
			document.getElementById("showNewsSource").innerText='来源:'+newsSource;
			document.getElementById("showNewsType").innerText='类型:'+newsType;
			document.getElementById("showNewsDate").innerText='日期:'+newsDate;
			document.getElementById("showNewsContent").innerText=newsContent;
			
		}
		
		</script>
		<meta charset="UTF-8">
		<title>校园新闻网管理系统</title>
		<style type="text/css">
			
			.head{
				height: 90px;
				width: 65%;
				/*border: 1px solid red;*/
				background: url(img/logo.2.png) no-repeat;
				background-size: 65% 110px;
			}
			.content{
				width: 100%;
				height: 600px;
				margin: 0 auto;
				/*border: 1px solid red;*/
				background: #002D64;
				padding-top: 50px;
				
			}
			.table-wrapper{
				width: 75%;
				height: 500px;
				margin: 0 auto;
				/*border: 1px solid red;*/
			}
			.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
			    padding: 8px 0 0;
			    line-height: 1.42857143;
			    vertical-align: top;
			    border-top: 1px solid #ddd;
			    text-align: center;
			    color: #FFFFFF;
			}
			.table > thead > tr > th {
			    vertical-align: bottom;
			    border-bottom: 2px solid #ddd;
			    font-size: 16px;
			    font-weight: bold;
			    }
			.active{
				display: inline-block;
				padding-left: 5px;
			}
			.newBtnDiv{
				height: 80px;
				width: 100%;
				position: relative;
				/*border: 1px solid red;*/
				background: #002A61;
			}
			
			
			
			.newBtn{
				display: inline-block;
				width: 120px;
				height: 40px;
				float: right;
				margin-right: 12.5%;
				border-radius: 5px;
				position: relative;
				background: #0090FF;
				margin-top: 25px;
				cursor: pointer;

			}
			.btnImg{
				position: absolute;
			    margin-top: 10px;
				margin-left: 6px;
				width: 20px;
				height: 20px;s

			}
			.detailBtn{
				display: inline-block;
				position: absolute;
				color: #FFFFFF;
				right: 6px;
			    font-size: 20px;
			    padding-top: 6px;
			}
			.modal-content{
				width: 1100px;
				height: 700px;
				right: 10%;
			}
			.modal-title{
				width: 100%;
				height: 40px;
				text-align: center;
			}
			.modal-head{
				height: 60px;
				width: 100%;
			}
			.line-detal{
				display: inline-block;
				height: 40px;
				width: 1000px;
				margin-left: 50px;
				margin-top: 40px;
				/*border: 1px solid red;*/
			}
			.new-title1{
				height: 30px;
				width: 300px;
				font-size: 16px;
				border-radius: 5px;
				border: 1px solid red;
				outline: none;
				padding-left: 5px;
			}
			.new-title2{
				height: 30px;
				width: 250px;
				font-size: 16px;
				border: 1px solid red;
				border-radius: 5px;
				outline: none;padding-left: 5px;
			}
			.new-title3{
				height: 30px;
				width: 200px;
				font-size: 16px;
				border: 1px solid red;
				border-radius: 5px;
				outline: none;
				padding-left: 5px;
			}
			.lable-title{
				font-size: 16px;
				font-weight: 200;
				margin-right: 5px;
				margin-left: 25px;
			}
			.news-detail{
				width: 1000px;
				height: 350px;
				margin:0 auto;
				margin-top: 40px;
				border-radius: 8px;
				border: 1px solid #999999;
			}
			.textarea-sty{
				resize: none;
				width: 1000px;
				height: 450px;
				outline: none;
			}
			.news-add-dismiss{
				width: 400px;
				height: 40px;
				position: relative;
				top: 40px;
				margin: 0 auto;
				
				
			}
			.btnNew{
				display: inline-block;
				width: 80px;
				height: 30px;
				margin-left: 80px;
				border: 1px solid #0090FF;
			    padding-top: 4px;
			    padding-left: 23px;
			    border-radius: 4px;
			    cursor: pointer;
			}
			.btnNew-add{
				background: #0090FF;
				color: #FFFFFF;
			}
			.news-details{
				width: 1000px;
				height: 350px;
				margin:0 auto;
				margin-top: 40px;
				border-radius: 8px;
				/*border: 1px solid #999999;*/
				overflow-y: scroll;
				background: #999999;
			}
			.account-manager{
				display: inline-block;
				width: 120px;
				height: 40px;
				background: #0090FF;
				padding: 11px 0 0 26px;
				margin-left: 12.5%;
				border-radius: 5px;
				margin-top: 25px;
			}
			.account-manager a{
				color: #FFFFFF;
				display: inline-block;
				height: 40px;
				width: 120px;
				text-decoration: none;
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
			color: #FFFFFF;
		}
		.paging .padeUl li a,.paging .padeUl li{
			text-decoration: none;
		}.paging .padeUl li:hover{
			color: #0090FF;
		}
			/*.bs-example-modal-lgWatch .modal-content{
				
			}*/
		.test-over,.test-over>p,.test-over>p>span{
				display: inline-block;
			    width:300px;
			    text-overflow: ellipsis;
			    overflow: hidden;
			    white-space: nowrap;
			    margin: 0;
			    padding: 0;
			    
			}
			.title {
				width: 200px;
				display: inline-block;
				text-overflow: ellipsis;
			    overflow: hidden;
			    white-space: nowrap;
			}
			.sources,.datatime{
				width: 150px;
				display: inline-block;
				text-overflow: ellipsis;
			    overflow: hidden;
			    white-space: nowrap;
			}
			.active{
				display: inline-block;
				width: 40px;
			}
		</style>
	</head>
	<body>
		<div class="head"></div>
		<div class="newBtnDiv">
			<span class="account-manager"><a href="account.jsp">账号管理</a></span>
			<span class="newBtn btn-primary"  data-toggle="modal" data-target=".bs-example-modal-lg" ><img class="btnImg" src="img/add.png"><lable class="detailBtn">新增新闻</lable></span>
		 
		</div>
		<div class="content">
			<div class="table-wrapper">
				<table class="table">
				<thead>
					<th>标题</th>
					<th>来源</th>
					<th>发布时间</th>
					<th>内容</th>
					<th>操作</th>
				</thead>
				<tbody>
					<jsp:include page="/showNews"/>
					<c:forEach items="${newes}" var="news">
					<tr>
						<td ><span class="title">${news.title }</span></td>
						<td ><span class="sources">${news.source }</span></td>
						<td ><span class="datatime">${news.date }</span></td>
						<td >
							<span class="test-over"">${news.content }</span>
						</td>
						<td >
							<span class="active"><a href="${pageContext.request.contextPath }/removeNews?nid=${news.nid}" onclick="alert('确认删除')">删除</a></span>
							<span class="active"><a href="javascript:" id="${news.nid }" data-toggle="modal" data-target=".bs-example-modal-lgs" newsTitle="${news.title }" newsSource="${news.source }" newsType="${news.type }" newsDate="${news.date }" newsContent="${news.content }" onclick="editNews(${news.nid})">修改</a></span>
							<span class="active"><a href="javascript:" id="${news.nid }" data-toggle="modal" data-target=".bs-example-modal-lgWatch" newsTitle="${news.title }" newsSource="${news.source }" newsType="${news.type }" newsDate="${news.date }" newsContent='${news.content} ' onclick="loadNews(${news.nid})">查看</a></span></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="paging">
				<ul class="padeUl">
					<li><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=${pageNum-1}"><</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=1">1</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=2">2</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=3">3</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=4">4</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=5">5</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=6">6</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=7">7</a></li>
					<li class="pages"><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=8">8</a></li>
					<li><a href="${pageContext.request.contextPath }/cms.jsp?pageNum=${pageNum+1}">></a></li>
				</ul>
			</div>
			</div>
			
		</div>
		
	</body>
	<!--新增模态框-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      	<div class="modal-title"><h2>新增新闻</h2></div>
      	<form action="${pageContext.request.contextPath }/addnews" method="post">
	     	<div class="modal-head">
		      	<span class="line-detal">
		      		<label class="lable-title">标题:</label>
		      		<input type="text" class="new-title1" name="title"/>
		      		<label class="lable-title">来源:</label>
		      		<input type="text" class="new-title2" name="source"/>
		      		<label class="lable-title" >分类:</label>
		      		<select class="new-title3" name="type">
		      			<option value="1">校内动态</option>
		      			<option value="2">校园风采</option>
		      			<option value="3">校园政策</option>
		      			<option value="4">生活常识</option>
		  			</select>
		      	</span>
	        </div>
	      	<div class="news-detail">
	      	  <textarea class="textarea-sty" name="content">在此处编辑新闻文本</textarea>
	        </div>
	    	<div class="news-add-dismiss">
	    		<input type="submit" class="btnNew btnNew-add" value="添加"></input>
    			<input type="button" class="btnNew btnNew-dismiss" data-dismiss="modal" value="取消"></input>
	    	</div>
<!-- 	    	<input type="submit" value="添加"/> -->
    	</form>
    </div>
  </div>
</div>

<!--修改模态框-->
<div class="modal fade bs-example-modal-lgs" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      	<div class="modal-title"><h2>修改新闻</h2></div>
     <form action="${pageContext.request.contextPath }/editNews" id="form" method="post">
	    <div class="modal-head">
	      	<span class="line-detal">
	      		<input type="text" style="display: none" id="nid" name="nid"/>
	      		<label class="lable-title">标题:</label>
	      		<input type="text" class="new-title1" name="title" id="editNewsTitle"/>
	      		<label class="lable-title">来源:</label>
	      		<input type="text" class="new-title2" name="source" id="editNewsSource"/>
	      		<label class="lable-title">分类:</label>
	      		<select class="new-title3" name="type" id="editNewsType">
	      			<option value="1">校内动态</option>
	      			<option value="2">校园风采</option>
	      			<option value="3">校园政策</option>
	      			<option value="4">生活常识</option>
	  			</select>
	      	</span>
	      </div>
	      <div class="news-detail">
	      	  <textarea class="textarea-sty" name="content" id="editNewsContent">在此处修改新闻文本</textarea>
	      </div>
		   <div class="news-add-dismiss">
		    	<input type="submit" class="btnNew btnNew-add" value="修改"></input>
	    		<input type="button" class="btnNew btnNew-dismiss" data-dismiss="modal" value="取消"></input>
		   </div>
	  </form>
    </div>
  </div>
</div>


<!--查看模态框-->
<div class="modal fade bs-example-modal-lgWatch" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      	<div class="modal-title"><h3 id="showNewsTitle"></h3></div>
     	 <div class="modal-head">
      	<span class="line-detal">
      		<label class="lable-title" id="showNewsSource"></label>
      		<label class="lable-title" id="showNewsType"></label>
      		<label class="lable-title" id="showNewsDate"></label>
      	</span>
      	
      </div>
      	<div class="news-details">
      		<p id="showNewsContent"></p>
      		</div>
    	<div class="news-add-dismiss">
    		<span class="btnNew btnNew-dismiss" data-dismiss="modal">取消</span>
    	</div>
    </div>
  </div>
</div>

<script>tinymce.init({ selector:'textarea' });</script><!--富文本编辑器插件-->
</html>
