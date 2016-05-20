package md.utm.entity.action.result;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

import md.utm.entity.action.user.ImageAction;

public class ImageResult implements Result {
	private static final long serialVersionUID = 1L;

	
	public void execute(ActionInvocation invocation) throws Exception {
		ImageAction action = (ImageAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(action.getContentType());
		byte[] image = action.loadImage();
		//InputStream in = new ByteArrayInputStream(image);
		
		if (image != null) {

			response.getOutputStream().write(image);
		}
		response.getOutputStream().flush();
	}
	
	
	
	

}
