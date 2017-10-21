<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 用户管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/employee_saveUI.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">用户姓名</td>
<td align="center">登录密码</td>
<td align="center">用户类型</td>
<td align="center">编辑</td>
</tr>
</thead>
<s:iterator value="list" var="e">
<tbody>
<tr>
<td align="center"><s:property value="#e.username"/></td>
<td align="center"><s:property value="#e.password"/></td>
<td align="center"><s:property value="#e.customerType"/></td>
<td align="center"><a href="editEmployee.html"><img src="${pageContext.request.contextPath}/images/page.gif"></a></td>
</tr>
</tbody>
</s:iterator>
</table>
<br/>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
   <span>总记录数:<s:property value="totalCount"/>&nbsp;&nbsp;每页显示:<s:property value="pageSize"/></span>
   <span>
   <s:if test="currPage !=1">
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currPage !=totalPage">
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>