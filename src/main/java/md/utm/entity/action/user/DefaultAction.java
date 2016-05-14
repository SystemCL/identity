package md.utm.entity.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Message;
import md.utm.entity.model.entity.Profile;

public class DefaultAction extends ActionSupport {
	
	private final Profile profile = new Profile();
	private final Message message = new Message();
	
	private MessageDAO messageDAO;
	private ProfileDAO profileDAO;
	
	private List<Profile> profileConversations;
	private List<Message> listMessages;
	
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}


	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}


	public ProfileDAO getProfileDAO() {
		return profileDAO;
	}


	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}


	public List<Profile> getProfileConversations() {
		return profileConversations;
	}


	public void setProfileConversations(List<Profile> profileConversations) {
		this.profileConversations = profileConversations;
	}


	public List<Message> getListMessages() {
		return listMessages;
	}


	public void setListMessages(List<Message> listMessages) {
		this.listMessages = listMessages;
	}


	public int getIdProfileOfConversation() {
		return idProfileOfConversation;
	}


	public void setIdProfileOfConversation(int idProfileOfConversation) {
		this.idProfileOfConversation = idProfileOfConversation;
	}


	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}


	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}


	public Profile getProfile() {
		return profile;
	}


	public Message getMessage() {
		return message;
	}



	
	int idProfileOfConversation;
	private Map<String, Object> sessionMap;
	
	
	public String getMessagesByIdProfile() {
		
		
		   listMessages = messageDAO.getMessagesForConversation(this.getIdProfileOfConversation());
		     System.out.println(listMessages.toString());
			
		    System.out.println(listMessages);
			if (listMessages == null) {
				listMessages = new ArrayList<Message>();
			}
			
			profileConversations = profileDAO.getProfilesWhoConversedWithMe();
			if (profileConversations == null) {
				profileConversations = new ArrayList<Profile>();
			}
			
		
		return Action.SUCCESS;
	
	   
	}
	
	
}
