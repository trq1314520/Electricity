package com.muke.employee.action;

import com.muke.employee.domain.Employee;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*员工管理的action类*/
/*使用模型驱动去接收数据（提供过来的用户名和密码）*/
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	/*getModel方法用户接收提交的数据提交的用户名和密码就被封装到了Employee对象当中中去了*/
	private Employee employee=new Employee();
	
	@Override
	public Employee getModel() {
		
		return employee;
	}
	/*登录执行的方法*/
	/*接收过来的数据login就可以使用其对象*/
	/*action需要去调用service层*/
	/*提供一个登录的方法*/
	public String login(){
		System.out.println("login方法执行了。。。。。");
		/*调用其service 层的login的方法 ，返回Employee的对象*/
		
		Employee existEmployee=employeeService.login(employee);
		if(existEmployee==null){
		//登录失败	
			this.addActionMessage("用户名或密码错误");
			return INPUT;
		}else{
			//登录成功,将用户的登录信息保存在session中                            要存的那个名字              所存的对象
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			/*保存完之后返回success的页面*/
			return SUCCESS;
		}
	
	 
 }
	/*在action中完成service的注入*/
private EmployeeService employeeService;
public void setEmployeeService(EmployeeService employeeService) {
	this.employeeService = employeeService;
}


}
