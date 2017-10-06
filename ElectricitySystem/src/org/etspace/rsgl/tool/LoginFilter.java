package org.etspace.rsgl.tool;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginFilter extends AbstractInterceptor {
	public String intercept(ActionInvocation arg0)throws Exception{
		Map session =arg0.getInvocationContext().getSession();
		Users user=session.get("user");
		if(user==null){
			return Action.LOGIN;
		}
		return arg0.invoke();
	}

}
