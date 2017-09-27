package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*���Ź����action��*/
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
/*ģ������ʹ�õĶ���*/
	private Department department=new Department();
	@Override
	public Department getModel() {
		
		return department;
	}
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//ע�벿�Ź����service,Ȼ����Ҫ��application.xml�н������ã���serviceע�뵽action��ȥ
	private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//�ṩһ����ѯ�ķ���
	public String findAll(){
		/*��action�н��з�ҳ�Ĳ�ѯ������Ҫ����ҵ���ķ���, ���ݵ�ǰ��ҳ�����в�ѯ��ͬʱ����һЩ��Ϣ�����ϰ�����ǰ��ҳ�����ܹ�����ҳ*/
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		/*��pageBean���뵽ֵջ��ȥ��֮��Ϳ��Է����ַ���*/
		return "findAll";
	}
	//����Ӱ�ť����ʱ�򣬾ͻ����һ��ҳ�棬Ҳ������ת����Ӳ��ŵ�ҳ��ķ�����
	public String saveUI(){
		return "saveUI";
		
	}
	//��Ӳ��ŵ�һ��ִ�еķ���
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//�༭���ŵ�ִ�з���
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}    
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//ɾ�����ŵ�һ��ִ�еķ���
	public String delete(){
	//����Ҫ��ѯ��Ȼ����ɾ��
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
