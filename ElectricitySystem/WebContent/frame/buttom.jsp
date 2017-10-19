<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
	<div align="center">
		<table border="0" width="60%" cellspacing="0" cellpadding="0"
			id="table1">
<!-- 			<tr>
				<td height="10"></td>
			</tr> -->
			<tr>
				<td>浙江工业大学信息工程学院</td>
				<td>欢迎用户:<s:property value="#session.existEmployee.username"/></td>
				<td>用户类型:</td>
				<td>登录时间:</td>
			</tr>
		</table>
	</div>
</body>
</html>