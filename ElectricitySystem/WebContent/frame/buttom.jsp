<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}

</SCRIPT>
</head>
<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
	<div align="center">
		<table border="0" width="60%" cellspacing="0" cellpadding="0"
			id="table1">
<!-- 			<tr>
				<td height="10"></td>
			</tr> -->
			<tr>
				<td>浙江工业大学信息工程学院&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>欢迎用户:<s:property value="#session.existEmployee.username"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>登录时间:
				            <SCRIPT language=JavaScript>

										 tmpDate = new Date();
										date = tmpDate.getDate();
										month= tmpDate.getMonth() + 1 ;
										year= tmpDate.getFullYear();
										time=tmpDate.toLocaleString();
/* 										document.write(year);
										document.write("年");
										document.write(month);
										document.write("月");
										document.write(date);
										document.write("日 "); */
										
/* 
										myArray=new Array(6);
										myArray[0]="星期日"
										myArray[1]="星期一"
										myArray[2]="星期二"
										myArray[3]="星期三"
										myArray[4]="星期四"
										myArray[5]="星期五"
										myArray[6]="星期六"
										weekday=tmpDate.getDay();
										if (weekday==0 | weekday==6)
										{
										document.write(myArray[weekday])
										}
										else
										{document.write(myArray[weekday])
										}; */
										
										/* document.write("当前时间"); */
										document.write(time); 
										
										</SCRIPT> 
										</td>
										
			</tr>
		</table>
	</div>
</body>
</html>