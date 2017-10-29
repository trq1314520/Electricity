<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 使用框架的时候，一般不能在body里面，否则就无效，所以一般都是将其直接在html标签中，一般现在的公司都使用div，很少使用frameset -->
<frameset rows="80,*">
	<frame name="top"
		src="${pageContext.request.contextPath }/frame/top.jsp">
	<frameset cols="150,*" id="main">
		<frame name="left"
			src="${pageContext.request.contextPath }/frame/left.jsp">
		<frameset rows="720,*">
			<frame name="right"
				src="${pageContext.request.contextPath }/frame/right.jsp">
			<frame name="buttom"
				src="${pageContext.request.contextPath }/frame/buttom.jsp">
		</frameset>
	</frameset>
</frameset>