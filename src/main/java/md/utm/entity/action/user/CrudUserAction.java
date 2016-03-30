package md.utm.entity.action.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.UserAccount;

public class CrudUserAction implements ModelDriven<UserAccount> {

	// incercare comenturi

	private UserAccount user = new UserAccount();
	private final Comment comment = new Comment();

	private UserDAO userDAO;
	private CommentDAO commentDAO;

	private List<UserAccount> userList;
	private List<Comment> commentList;

	private Integer userId;

	public List<UserAccount> getUserList() {
		return userList;
	}

	public void setUserList(List<UserAccount> userList) {
		this.userList = userList;
	}

	public UserAccount getModel() {
		return user;

	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
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
			userList = new ArrayList<UserAccount>();
		}
		return Action.SUCCESS;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	// list all comments
	public String populateCommentList() {
		commentList = commentDAO.getAllComments();
		if (commentList == null) {
			commentList = new ArrayList<Comment>();
		}
		return Action.SUCCESS;
	}

}
