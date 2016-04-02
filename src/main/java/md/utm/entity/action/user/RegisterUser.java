package md.utm.entity.action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.UserAccount;

public class RegisterUser implements ModelDriven<UserAccount> {
	private final UserAccount user = new UserAccount();
     private UserDAO userDAO;

	public String registerUser() throws Exception {
		 userDAO.save(user);
		if (user.getUsername() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	
	
	public UserAccount getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
