<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

  //  d.add('01','-1','电流监测管理系统');
/*     d.add('0101','01','人力资源部');
    d.add('010101','0101','部门管理','listDep.html','','right');
    d.add('010102','0101','员工管理','listEmployee.html','','right'); */
    
    d.add('01','-1','电流监测管理系统');
    d.add('0101','01','用户管理');
    d.add('010101','0101','用户管理','${pageContext.request.contextPath}/employee_findAll.action','','right');
    d.add('0102','01','日志管理');
    d.add('010201','0102','日志管理','rizhi.jsp','','right');
    d.add('0103','01','实验室管理');
    d.add('010301','0103','实验室一','library1.jsp','','right');
    d.add('010302','0103','实验室二','library2.jsp','','right');
    d.add('010303','0103','实验室三','library3.jsp','','right');
    d.add('010404','0103','实验室四','library4.jsp','','right'); 
/*     d.add(1,-1,'电流监测管理系统');
    d.add(2,0,'用户','','','','${pageContext.request.contextPath}/img/folder.gif');
    d.add(3,1,'用户管理','listEmployee.jsp','','right');
    d.add(4,0,'日志','','','','img/folder.gif');
    d.add(5,1,'日志管理','rizhi.jsp','','right');
    d.add(6,0,'实验室管理','','','','img/folder.gif');
    d.add(7,1,'实验室一','','','right');
    d.add(8,1,'实验室二','','','right');
    d.add(9,1,'实验室三','','','right');
    d.add(10,1,'实验室四','','','right');  */
    document.write(d);
  </script>
</div>
</table>

</body>
</html>
