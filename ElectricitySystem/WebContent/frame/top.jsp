<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
</style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
<%-- //value表示传的值<s:property>是struts的标签，不是标准的html标签 --%>
<%-- 欢迎您：<s:property value="#session.existEmployee.ename"/> --%>
浙江工业大学实验室电流监测管理系统V1.0版本
</div>
</body>
</html>
