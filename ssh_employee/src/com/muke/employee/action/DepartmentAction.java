package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*部门管理的action类*/
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
/*模型驱动使用的对象*/
	private Department department=new Department();
	@Override
	public Department getModel() {
		
		return department;
	}
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//注入部门管理的service,然后需要在application.xml中进行配置，将service注入到action中去
	private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//提供一个查询的方法
	public String findAll(){
		/*在action中进行分页的查询，就需要调用业务层的方法, 根据当前的页数进行查询，同时返回一些信息，集合包括当前的页数，总共多少页*/
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		/*将pageBean放入到值栈中去了之后就可以返回字符串*/
		return "findAll";
	}
	//当添加按钮出现时候，就会出来一个页面，也就是跳转到添加部门的页面的方法：
	public String saveUI(){
		return "saveUI";
		
	}
	//添加部门的一个执行的方法
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门的执行方法
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}    
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//删除部门的一个执行的方法
	public String delete(){
	//先需要查询，然后再删除
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
