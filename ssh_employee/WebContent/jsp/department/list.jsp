<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">部门管理</td>
		</tr>
		<!-- 		<tr>
			<td align="right"><a href="addDepartment.jsp">添加</a></td>
		</tr> -->
		<tr>
			<!-- //添加按钮完成页面的跳转 -->
			<td width="57%" align="right"><a
				href="${pageContext.request.contextPath}/department_saveUI.action">添加</a>

			</td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th width="450">部门名称</th>
				<th width="450">编辑</th>
				<th width="450">删除</th>
			</tr>
		</thead>
		<tbody>
			<!-- var用来定义变量的 d就为变量 -->
			<s:iterator value="list" var="d">
				<tr>
					<!-- 遍历显示每个值                                            d.dname就是按照名字来遍历-->
					<td align="center"><s:property value="#d.dname" /></td>
					<!-- 编辑的按钮，在编辑按钮，按下去之后，就会提交相应的数据，给action去处理，在编辑时候需要知道编辑的是哪一条记录 -->
					<td width=9% align="center"><a href="${pageContext.request.contextPath }/department_edit.action?did=<s:property value="#d.did"/>" > <img
							src="${pageContext.request.contextPath }/images/edit.png"  />
							</a>
							</td>
					<td width=7% align="center"><a href="${pageContext.request.contextPath }/department_delate.action?did=<s:property value="#d.did"/>" > <img
							src="${pageContext.request.contextPath }/images/page.gif" />
					</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>

	</table>
	<br />


	<table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td align="right">
				<!-- //显示空格 --> <span>第<s:property value="currPage" />/<s:property
						value="totalPage" />页
			</span>&nbsp;&nbsp; <span>总记录数：<s:property value="totalCount" />&nbsp;&nbsp;每页显示：<s:property
						value="pageSize" /></span>&nbsp;&nbsp; <span> <s:if
						test="currPage !=1">
						<a
							href="${pageContext.request.contextPath }/department_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
   </s:if> <s:if test="currPage !=totalPage">
						<a
							href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a
							href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
			</span>
			</td>
		</tr>
	</table>
</body>
</html>