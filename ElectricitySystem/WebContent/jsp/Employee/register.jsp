<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/style/reset.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/style/main.css">
<script type="text/javascript">
	function checkForm() {
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if (password == null || password == '') {
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if (repassword != password) {
			alert("两次密码输入不一致!");
			return false;
		}
	}
</script>
</head>
<body>
	<form id="registerForm"
		action="${ pageContext.request.contextPath }/employee_save.action"
		method="post" novalidate="novalidate" onsubmit="return checkForm();">
		<h2>用户注册</h2>
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="username" name="username" placeholder="请输入您的用户名"
					required class="input-text"></td>
			</tr>
			<tr>
				<td>用户密码：</td>
				<td><input type="password" id="password" name="password" required
					class="input-text"></td>
			</tr>
			<tr>
				<td>密码确认：</td>
				<td><input type="password" id="repassword" name="repassword" required
					class="input-text"></td>
			</tr>
			<tr>
				<td>用户类型：</td>
				<td><label><input type="checkbox" 
					required class="td-center">普通用户</label></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td class="td-center" colspan="3" >
				<input type="submit" value="注册" class="submit">
				</td>
			</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
