package md.utm.entity.action.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.UserAc;


public class CrudUserAction implements ModelDriven<UserAc> {

	private UserAc user = new UserAc();

	private UserDAO userDAO;

	private List<UserAc> userList;

	private Integer userId;

	public List<UserAc> getUserList() {
		return userList;
	}

	public void setUserList(List<UserAc> userList) {
		this.userList = userList;
	}

	public UserAc getModel() {
		return user;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String addUser() throws Exception {
		user.setCreatedDate(new Date());
		userDAO.save(user);
		if (user.getUsername() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public String updateUser() {
		userDAO.saveOrUpdate(user);
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String editUser() {
		String returnType = Action.NONE;
		if (userId != null) {
			ActionContext.getContext().getValueStack().getRoot().remove(user);
			user = getUserDAO().findUser(userId);
			ActionContext.getContext().getValueStack().getRoot().add(user);
			returnType = Action.SUCCESS;
		}
		return returnType;
	}

	public String removeUser() {
		if (userId != null) {
			getUserDAO().deleteUser(userId);
		}
		return Action.SUCCESS;
	}

	// list all users
	public String listAllUsers() {
		userList = userDAO.getAllUsers();
		if (userList == null) {
			userList = new ArrayList<UserAc>();
		}
		return Action.SUCCESS;
	}
}
