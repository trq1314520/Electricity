<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 用户编辑</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form id="saveForm" action="employee_update" method="post" namespace="/" theme="simple">
<s:hidden name="eid" value="%{model.eid }"/>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>用户姓名：</td>
<td><s:textfield name="username"  value="%{model.username}"/></td>
<td>登录密码：</td>
<td><s:textfield name="password" value="%{model.password}"/></td>
</tr>
<tr>
<td>用户类型：</td>
<td><s:textfield name="customerType" value="%{model.customerType}"/></td>
</table>
</s:form>

</body>
</html>