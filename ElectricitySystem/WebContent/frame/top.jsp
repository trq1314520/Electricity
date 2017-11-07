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
		浙江工业大学实验室设备电流监测管理系统V1.0版本
	</div>
	<div class="div2">
	<table>
	<tr>
	<s:iterator var="l" value="#session.clist">
	<!-- 从页面中带入以及分类的数据和当前的页数 -->
	<td><a href="${pageContext.request.contextPath }/device_findByLid.action?lid=<s:property value="#l.lid"/>&currPage=1" target="right"><s:property value="#l.lname"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<%-- <td><a href="#" target="_blank">实验室二</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><a href="${pageContext.request.contextPath }/library_find.action">实验室三</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><a href="${pageContext.request.contextPath }/library_find.action">实验室四</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><a href="${pageContext.request.contextPath }/library_find.action">实验室五</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> --%>
	</s:iterator>
	</tr>
	</table>
	</div>
</body>
</html>
