package main.java.Interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginedInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2398376558013164697L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		String user = (String) session.get("usersession");
		if (user!= null) {
			return invocation.invoke();
		}
		return Action.LOGIN;
	}

}