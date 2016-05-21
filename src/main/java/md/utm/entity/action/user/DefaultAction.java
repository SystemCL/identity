package md.utm.entity.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Message;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class DefaultAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private Profile profile;
	private final Message message = new Message();

	private MessageDAO messageDAO;
	private ProfileDAO profileDAO;
	private CommentDAO commentDAO;

	private UserAccount user;
	private Integer idSender;

	private List<Profile> profileConversations;
	private List<Message> listMessages;
	private List<Comment> commentList;

	Integer idProfileOfConversation;
	private Map<String, Object> sessionMap;

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public void setIdSender(Integer idSender) {
		this.idSender = idSender;
	}

	public Integer getIdSender() {
		return idSender;
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

	public Integer getIdProfileOfConversation() {
		return idProfileOfConversation;
	}

	public void setIdProfileOfConversation(Integer idProfileOfConversation) {
		this.idProfileOfConversation = idProfileOfConversation;
	}

	public Profile getProfile() {
		return profile;
	}

	public Message getMessage() {
		return message;
	}

	public String getMessagesByIdProfile() {
		idSender = idProfileOfConversation;
		if (this.getIdProfileOfConversation() != null) {
			listMessages = messageDAO.getMessagesForConversation(this.getIdProfileOfConversation());
			System.out.println(listMessages.toString());
		}
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

	/*
	 * Load main page, user info with photo & comments
	 */
	public String loadMainPage() {

		profile = profileDAO.getSesionProfile();
		if (profile == null) {
			return "createProfile";
		} else {
			sessionMap.put("profile_id", profile.getIdProfile());
			sessionMap.put("firstName", profile.getFirstName());
			sessionMap.put("lastName", profile.getLastName());
			sessionMap.put("email", profile.getEmail());
			sessionMap.put("dBirthday", profile.getdBirthday());

			System.out.println(profile.getFirstName() + " " + profile.getLastName() + " " + profile.getEmail());
			commentList = commentDAO.getAllComments();
			if (commentList == null) {
				commentList = new ArrayList<Comment>();
			}
		}

		// sessionMap.put("firstName", "Adrian");
		// sessionMap.put("lastName", "Tabirta");

		// sessionMap.put("logged", true);
		// sessionMap.put("user_id", user.getIdAccount());

		/*
		 * Profile profileUser = user.getProfile(); if (profileUser == null) {
		 * return "createProfile"; } else { sessionMap.put("profile_id",
		 * profileUser.getIdProfile()); }
		 */

		// commentList = commentDAO.getAllComments();
		// if (commentList == null) {
		// commentList = new ArrayList<Comment>();
		// }
		return Action.SUCCESS;

	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

}
