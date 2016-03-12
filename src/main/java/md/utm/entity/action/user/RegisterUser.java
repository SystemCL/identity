package md.utm.entity.action.user;



import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.entity.impl.Registration;
import md.utm.entity.model.entity.impl.UserAc;


public class RegisterUser implements ModelDriven<UserAc>  {
	private UserAc user = new UserAc();
	//private UserDAO userDAO;
	
	
	public String addUser() throws Exception {
		//userDAO.save(user);
		if (user.getUsername() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
	public UserAc getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
