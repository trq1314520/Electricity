package com.es.employee.action;

import com.es.employee.domain.Employee;
import com.es.employee.domain.PageBean;
import com.es.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*员工管理的action类*/
/*使用模型驱动去接收数据（提供过来的用户名和密码）*/
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	/* getModel方法用户接收提交的数据提交的用户名和密码就被封装到了Employee对象当中中去了 */
	private Employee employee = new Employee();

	@Override
	public Employee getModel() {

		return employee;
	}

	/* 登录执行的方法 */
	/* 接收过来的数据login就可以使用其对象 */
	/* action需要去调用service层 */
	/* 提供一个登录的方法 */
	public String login() {
		System.out.println("login方法执行了。。。。。");
		/* 调用其service 层的login的方法 ，返回Employee的对象 */

		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			// 登录失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		} else {
			// 登录成功,将用户的登录信息保存在session中 要存的那个名字 所存的对象
			ActionContext.getContext().getSession()
					.put("existEmployee", existEmployee);
			/* 保存完之后返回success的页面 */
			return SUCCESS;
		}

	}

	public String register() {
		return "register";
	}

	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}

	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 接收传进来的值，需要使用set方法

	// 提供一个查询的方法
	public String findAll() {
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
	}
    public String saveUI(){
    	//查询所有的用户
    	return "saveUI";
    }
    //编辑修改用户的信息
    public String edit(){
    	//根据id的信息进行查询，但是id的信息已经封装到模型驱动中，直接调用业务层去查询即可，由于action层值负责控制，并不涉及查询
    	employee=employeeService.findById(employee.getEid());
    	return "editSuccess";
    }
    //修改员工一个执行的方法
    public String update(){
    	employeeService.update(employee);
    	return "updateSuccess";
    }

    public String delete(){
    	employee=employeeService.findById(employee.getEid());
    	employeeService.delete(employee);
    	return "deleteSuccess";
    }
	/* 在action中完成service的注入 */
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
