package md.utm.entity.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class LoginAuthAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserDAO userDAO;
	private Profile userProfile;

	private Boolean error;
	private Map<String, Object> sessionMap;
	private UserAccount user;

	@Override
	public String execute() {
		if (username.equals("")) {
			addActionError("Please Enter username.");
			error = true;
		} else if (password.equals("")) {
			addActionError("Please Enter password.");
			error = true;
		} else if (username.equalsIgnoreCase(password)) {
			addActionError("Username and password should be different.");
			error = true;
		} else if (findUser() == null) {
			error = true;
		} else {
			error = false;
			sessionMap.put("username", user.getUsername());
			sessionMap.put("logged", true);
			sessionMap.put("user_id", user.getIdAccount());

			Profile profileUser = user.getProfile();
			if (profileUser == null) {
				return "createProfile";
			} else {
				sessionMap.put("profile_id", profileUser.getIdProfile());
			}
		}

		if (error) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	public String logOut() {
		if (sessionMap.containsKey("username")) {
			sessionMap.remove("username");
			sessionMap.remove("user_id");
			sessionMap.remove("profile_id");
			sessionMap.put("logged", false);
			sessionMap.put("admin", false);
		}
		return SUCCESS;
	}

	private UserAccount findUser() {
		user = userDAO.findUser(username, password);
		return user;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

}
