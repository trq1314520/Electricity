<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>设备</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container productList">

		<div class="span18 last">
			<div id="result" class="result table clearfix">
				<ul>
					<s:iterator var="e" value="pageBean.list">
						<li style="display:inline-block;">
							<%-- 实现向商品详情的跳转 ${ pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#e.eid"/> --%>
							<a
							href="${ pageContext.request.contextPath }/electricity_findByElid.action?eid=<s:property value="#e.eid"/>">
								<img style="display:inline-block;"
								src="${pageContext.request.contextPath}/<s:property value="#e.eimagepath"/>"
								width="170" height="170" /> 
								<p style="color: green; text-align: center"> <s:property value="#e.ename" />
							</p>
						</a>
						</li>
					</s:iterator>

				</ul>
			</div>
			<div class="pagination">
				<span>第 <s:property value="pageBean.currPage" />/<s:property
						value="pageBean.totalPage" /> 页
				</span> <span>总记录数:<s:property value="pageBean.totalCount" />&nbsp;&nbsp;每页显示:<s:property
						value="pageBean.pageSize" /></span>
				<s:if test="lid != null">
					<s:if test="pageBean.currPage != 1">
						<a
							href="${ pageContext.request.contextPath }/device_findByLid.action?lid=<s:property value="lid"/>&currPage=1"
							class="firstPage">&nbsp;</a>
						<a
							href="${ pageContext.request.contextPath }/device_findByLid.action?lid=<s:property value="lid"/>&currPage=<s:property value="pageBean.currPage-1"/>"
							class="previousPage">&nbsp;</a>
					</s:if>

					<s:iterator var="i" begin="1" end="pageBean.totalPage">
						<s:if test="pageBean.currPage != #i">
							<a
								href="${ pageContext.request.contextPath }/device_findByLid.action?lid=<s:property value="lid"/>&currPage=<s:property value="#i"/>"><s:property
									value="#i" /></a>
						</s:if>
						<s:else>
							<span class="currentPage"><s:property value="#i" /></span>
						</s:else>
					</s:iterator>

					<s:if test="pageBean.currPage != pageBean.totalPage">
						<a class="nextPage"
							href="${ pageContext.request.contextPath }/device_findByLid.action?lid=<s:property value="lid"/>&currPage=<s:property value="pageBean.currPage+1"/>">&nbsp;</a>
						<a class="lastPage"
							href="${ pageContext.request.contextPath }/device_findByLid.action?lid=<s:property value="lid"/>&currPage=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
					</s:if>
				</s:if>

			</div>
		</div>
	</div>

</body>
</html>