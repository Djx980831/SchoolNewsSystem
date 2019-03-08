<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/reset.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
		<!--<script type="text/javascript" src="js/bootstrap.js" ></script>-->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/page.css" />
		<title>校园新闻网管理系统</title>
		<style>
			.header{
				height: 90px;
				width: 65%;
				/*border: 1px solid red;*/
				background: url(img/logo.2.png) no-repeat;
				background-size: 65% 110px;
			}
			.account-left{
				float: left;
				width: 15%;
				height: 660px;
				background: #003574;
			}
			.account-left ul{
				padding-top: 15px;
			}
			.account-left li{
				width: 100%;
				font-size: 18px;
				height: 40px;
				background: #003574;
				color: #FFFFFF;
			    padding-left: 30%;
    			padding-top: 7px;
    			display: inline-block;
    			cursor: pointer;
				
			}
			.account-left li:hover{
				/*color: orange;*/
				background: #0090ff;
			}
			.right-content{
				position: relative;
				float: right;
				width: 85%;
				height: 660px;
				/*border: 1px solid red ;*/
				background: #002D64;
			}
			.fix-password{
				position: absolute;
				width: 100%;
				height: 100%;
				/*border: 1px solid red;*/
			}
			.wrapper-password{
				width: 300px;
				height: 200px;
				/*border: 1px solid yellow;*/
			    margin: 12% 0 0 40%;
				
			}
			.passwords{
				    width: 281px;
    				height: 33px;
    				background: none;
				    outline: none;
				    border: 1px solid #0090FF;
				    margin-bottom: 20px;
				    border-radius: 5px;
				    padding-left: 5px;
				    color: #FFFFFF;
				    font-size: 16px;
			}
			::-webkit-input-placeholder { /* WebKit browsers */
			    color:    #FFFFFF;
			}
			:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
			    color:    #FFFFFF;
			}
			::-moz-placeholder { /* Mozilla Firefox 19+ */
			    color:    #FFFFFF;
			}
			:-ms-input-placeholder { /* Internet Explorer 10+ */
			    color:    #FFFFFF;
			}
			.sure{
				width: 280px;
				height: 35px;
				background: #0090FF;
				border-radius:6px;
				border: none;
				color: #FFFFFF;
				outline: none;
				
			}
			.error-title{
				height: 40px;
				width: 100%;
				display: block;
				/*border: 1px solid red;*/
				margin-top: 10px;
				text-align: center;
			}
			.fix-title{
				font-size: 18px;
				color: red;
				font-weight: bold;
			}
			
			.account-new{
				position: absolute;
				width: 100%;
				height: 100%;
				/*border: 1px solid red;*/
			}
			.new-btn-wrapper{
				position: relative;
				width: 100%;
				height: 70px;
				/*border: 1px solid yellow;*/
			}
			.new-btn{
				float: right;
				height: 40px;
				width: 120px;
				display: inline-block;
				border: 2px solid #0090FF;
			    margin-right: 12.5%;
			    border-radius: 5px;
			    margin-top: 17px;
			    padding-top: 7px;
			    padding-left: 18px;
			    font-size: 17px;
			    color: #FFFFFF;
			    cursor: pointer;
			}
			.account-table{
				width: 50%;
				height: 500px;
				/*border: 1px solid yellow;*/
				margin: 0 auto;
			}
			.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
			    padding: 8px;
			    line-height: 1.42857143;
			    text-align: center;
			    vertical-align: top;
			    border-top: 1px solid #ddd;
			    color: #FFFFFF;
			    }
			    .table > thead > tr > th {
				    vertical-align: bottom;
				    border-bottom: 2px solid #ddd;
				    font-size: 16px;
				    font-weight: bold;
				}
				.modal-content{
					width: 800px;
					height: 500px;
				    margin-left: 3%;
    				margin-top: 13%;
    				background: #002A61;
				}
				.wrapper-content{
					width: 100%;
					height: 100%;
					position: relative;
				}
				.new-account-wrapper{
					width: 300px;
					height: 250px;
					/*border: 1px solid yellow;*/
					margin: 0 auto;
					margin-top: 10%;
					text-align: center;
					
					
				}
				.common-style{
					width: 280px;
					height: 40px;
					border: 1px solid #0090FF;
					outline: none;
					border-radius:5px ;
					background: none;
					margin-bottom: 20px;
					color: #FFFFFF;
					font-size: 16px;
					padding-left: 5px;
				}
				.add-btn{
					height: 40px;
					width: 280px;
					background: #0090FF;
					color: #FFFFFF;
					border-radius: 5px;
					outline: none;
					border: none;
				}
				.account-left .color2{
					background: #0090FF;
				}
		</style>
	</head>
	<body>
		<div class="header"></div>
		<div class="account-left">
			<ul>
				<li class="default-color color2">修改密码</li>
				<li class="default-color ">新建账号</li>
			</ul>
		</div>
		<div class="right-content">
			<div class="fix-password" style="display: block;">
				<div class="wrapper-password">
				<form action="${pageContext.request.contextPath }/modifyAccount?mid=${manager.mid}" method="post">
					<input type="password" class="passwords passwords-old" name="oldPassword" placeholder="请输入旧密码"/>
					<input type="password" class="passwords passwords-new" name="newPassword" placeholder="请输入新密码"/>
					<input type="submit" value="确定" class="sure"/>
				</form>
					<span class="error-title"><p class="fix-title old-pwd" >旧密码错误！！</p><p class="fix-title new-pwd" style="display: none;">修改成功！！</p></span>
				</div>
			</div>
			<div class="account-new" style="display: none;">
					<div class="new-btn-wrapper">
						<span class="new-btn" data-toggle="modal" data-target=".bs-example-modal-lg">
							<img src="img/add-btn.png" style="padding-bottom: 3px;padding-right: 3px;">
							<a style="color: #FFFFFF;text-decoration: none;">新建账号</a></span>
					</div>
					<div class="account-table">
						<table class="table">
							<thead>
								<tr>
									<th>账号</th>
									<th>邮箱</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<jsp:include page="showManager"/>
								<c:forEach items="${managers }" var="manager">
									<tr>
										<td>${manager.username}</td>
										<td>${manager.email }</td>
										<td><a href="${pageContext.request.contextPath }/removeManager?mid=${manager.mid}">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<!--分页-->
						<div class="paging">
							<ul class="padeUl">
								<li><a href="${pageContext.request.contextPath }/account.jsp?pageNum=${pageNum2-1}"><</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=1">1</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=2">2</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=3">3</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=4">4</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=5">5</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=6">6</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=7">7</a></li>
								<li class="pages"><a href="${pageContext.request.contextPath }/account.jsp?pageNum=8">8</a></li>
								<li><a href="${pageContext.request.contextPath }/account.jsp?pageNum=${pageNum2+1}">></a></li>
							</ul>
						</div>
						<!--分页-->
					</div>
					
				</div>
		</div>
		
	</body>
	<!--modal-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div wrapper-content>
		      	<div class="new-account-wrapper">
		      	<form action="${pageContext.request.contextPath }/addManager" method="post">
		      		<input type="text" class="common-style" name="username" placeholder="请输入用户名"/>
		      		<input type="text" class="common-style" name="password" placeholder="请输入邮箱账号"/>
		      		<input type="password" class="common-style" name="email" placeholder="请输入密码"/>
		      		<input type="submit" class="add-btn" value="新建"/>
		      	</form>
		      	</div>
		      	
		      </div>
		    </div>
		</div>
	</div>
	<script>
		$('.default-color').click(function(){
			/*alert($(this).index())*/
			$('.default-color').removeClass('color2');
			$(this).addClass("color2")
			if($(this).index()==1){
				$('.fix-password').css('display','none');
				$(".account-new").css('display','inline');
			}else{
				$(".account-new").css('display','none');
				$('.fix-password').css('display','block');
			}
		});
	</script>
</html>