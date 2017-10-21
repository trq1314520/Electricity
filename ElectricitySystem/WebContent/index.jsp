<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入struts的标签库 -->
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎登陆</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/style/reset.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/style/main.css">
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
<style type="text/css">
 body{background:url(images/library8.jpg) no-repeat center top;} 
 .login_cont a {color:#E50007;}
</style>
</head>

<body>
	<div class="headerBar">
		<div class="logoBar login_logo">
				<div class="logo fl">
					<a  href="http://www.zjut.edu.cn" target="_blank" title="点击访问浙江工业大学官网首页"><img
						src="${pageContext.request.contextPath }/images/library4.jpg"></a>
				</div>
				<h5 class="welcome_title">欢迎登陆实验室电流检测系统</h5>
		</div>
	</div>
	<s:form action="employee_login" method="post" namespace="/">
		<!-- //<form action="frame.html" method="post"> -->
		<div class="loginBox">
			<!-- 回显错误信息 -->
			<h3>
				<s:actionerror />
			</h3>
			<div class="login_cont">
				<ul class="login">
					<li class="l_tit">用户名</li>
					<li class="mb_10"><input type="text" name="username" placeholder="邮箱/QQ号码"
						class="login_input user_icon"></li>
					<li class="l_tit">密码</li>
					<li class="mb_10"><input type="password" name="password"
						class="login_input user_icon"></li>
					<li class="l_tit">用户类型</li>
					<li class="mb_10">
					<select class="login_input" type="checkbox" >
					<option value="1" selected>管理人员</option>
					<option value="2" >普通人员</option>
					</select>
					</li>
					<li><input type="submit" value="" class="login_btn"></li>
					<li><a href="${pageContext.request.contextPath }/employee_register.action">注册?</a></li>
				</ul>
			</div>
		</div>
	</s:form>
	<div class="hr_25"></div>
	<div class="footer">
		<p>
			<a href="#">通讯地址</a><i>:</i><a href="#">浙江省杭州市西湖区留下镇留和路288号</a>
		</p>
		<!-- //<p>Copyright &copy; 2006 - 2014 慕课版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p> -->
		<p>邮编：310023&nbsp;&nbsp;&nbsp;电话：(0571)85290114&nbsp;</p>
		<%-- //<p class="web"><a href="#"><img src="images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath }/images/webLogo.jpg" alt="logo"></a></p> --%>
	</div>
</body>
</html>
