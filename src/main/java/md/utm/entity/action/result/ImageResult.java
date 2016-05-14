package md.utm.entity.action.result;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

import md.utm.entity.action.user.ImageAction;

public class ImageResult implements Result {
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ImageAction action = (ImageAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType(action.getContentType());

		response.getOutputStream().write(action.loadImage());
		response.getOutputStream().flush();
	}

}
