<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门编辑</td>
</tr>
<tr>
<td align="right" > 
<!-- 确认的id                当点击保存时候，就会将数据提交给department_saveQ去做相应的保存在数据库中-->
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;

<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
 <!-- 当点击保存的按钮时候，就会交给update action去处理 -->
 <!-- 表单                                                                                                                                                    theme表示对齐-->
 <s:form id="saveForm" action="department_update" method="post" namespace="/" theme="simple">
 <!-- 同时要知道Did是谁 ，隐藏的文件-->
<s:hidden name="did" value="%{model.did}"/>
<table style="font-size::16px">
<tr>
  <td>部门名称：</td>
  <td> <s:textfield name="dname" value="%{model.dname}" /> </td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <s:textarea cols="50" rows="5" name="ddesc" value="%{model.ddesc}"/>
  </td>
</tr>
</table>
</s:form>
</body>
</html> 