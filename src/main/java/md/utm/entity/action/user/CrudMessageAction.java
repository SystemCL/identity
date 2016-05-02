package md.utm.entity.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javassist.bytecode.Descriptor.Iterator;
import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Message;

public class CrudMessageAction extends ActionSupport implements ModelDriven<Message>, SessionAware {
	
	private MessageDAO messageDAO;
	List<Message> listMessages;
	private final Message message = new Message();
	private Map<String, Object> sessionMap;
	
	
	
public String getMessagesBySenderId()  {
		
		// to do--> get sender id
	    listMessages = messageDAO.getMessagesBySenderId();
		
	    System.out.println(listMessages);
		if (listMessages == null) {
			listMessages = new ArrayList<Message>();
		}
		
		return Action.SUCCESS;
		
		
	}

	public List<Message> getMessageList() {
		return listMessages;
	}
	
	
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	public Message getModel() {
		// TODO Auto-generated method stub
		return message;
	}

}
