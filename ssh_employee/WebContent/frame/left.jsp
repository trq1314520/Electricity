<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- rel属性，描述了当前页面与href所指定文档的关系 ，即href是连接的文档是一个新式表-->
<!-- stylesheet中style是样式的意思，sheet是表格的意思 -->
<link href="dtree.css" rel="stylesheet" type="text/css">
<!-- <script>脚本元素即可包含脚本语句，可以可以通过"src"属性指向外部脚本语言</script> -->
<!-- src外部引用 -->
<script type="text/javascript" src="dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','员工管理系统');//父节点为-1，根节点
    d.add('0101','01','人力资源部');
    d.add('010101','0101','部门管理','${pageContext.request.contextPath}/department_findAll.action','','right');

    d.add('010102','0101','员工管理','listEmployee.jsp','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>