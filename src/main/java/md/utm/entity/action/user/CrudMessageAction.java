package md.utm.entity.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Message;

public class CrudMessageAction extends ActionSupport implements ModelDriven<Message>, SessionAware {

	private MessageDAO messageDAO;
	private ProfileDAO profileDAO;
	List<Message> listMessages;
	private Message message = new Message();
	private Map<String, Object> sessionMap;
	int idProfileOfConversation;
	private Integer idMessageSender;

	public void setIdMessageSender(Integer idMessageSender) {
		this.idMessageSender = idMessageSender;
	}

	public Integer getIdMessageSender() {
		return idMessageSender;
	}

	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	public ProfileDAO getProfileDAO() {
		return profileDAO;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public List<Message> getListMessages() {
		return listMessages;
	}

	public void setListMessages(List<Message> listMessages) {
		this.listMessages = listMessages;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Message getMessage() {
		return message;
	}

	public int getIdProfileOfConversation() {
		return idProfileOfConversation;
	}

	public void setIdProfileOfConversation(int idProfileOfConversation) {
		this.idProfileOfConversation = idProfileOfConversation;
	}

	public String getMessagesBySenderId() {

		// to do--> get sender id
		// listMessages = messageDAO.getMessagesBySenderId();
		// System.out.println("Id-ul senderului pentru
		// mesaje"+this.idProfileOfConversation);
		listMessages = messageDAO.getMessagesForConversation(this.getIdProfileOfConversation());
		System.out.println(listMessages.toString());

		System.out.println(listMessages);
		if (listMessages == null) {
			listMessages = new ArrayList<Message>();
		}

		return Action.SUCCESS;
	}

	public String sendMessageToProfile() {

		message = messageDAO.createAMessage(message);

		if (message.getIdMessage() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;

	}

	
	public Message getModel() {
		// TODO Auto-generated method stub
		return message;
	}

	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

}
