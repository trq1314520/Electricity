<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style type="text/css">
.div1 {
	margin-top: 20px;
	margin-left: 500px;
	font-size: 20px;
	color: white;
}
.div2{margin-top:10px;margin-left:300px;font-size:15px;color:white;}
</style>
</head>

<body bgcolor="#0099FF">
	<div class="div1">
		<%-- //value表示传的值<s:property>是struts的标签，不是标准的html标签 --%>
		<%-- 欢迎您：<s:property value="#session.existEmployee.ename"/> --%>
		浙江工业大学实验室电流监测管理系统V1.0版本
	</div>
	<div class="div2">
	<tr>
	<td><a href="#" target="_blank">实验室一</a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<td><a href="#" target="_blank">实验室二</a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<td><a href="${pageContext.request.contextPath }/library_find.action">实验室三</a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<td><a href="${pageContext.request.contextPath }/library_find.action">实验室四</a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<td><a href="${pageContext.request.contextPath }/library_find.action">实验室五</a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</tr>
	</div>
</body>
</html>
