package md.utm.entity.action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class RegisterUser implements ModelDriven<UserAccount> {
	private final UserAccount user = new UserAccount();
     private UserDAO userDAO;
     
     private Profile profile;
     private ProfileDAO profileDAO;

	public String registerUser() throws Exception {
		
		
		Profile profile = new Profile();
		profile.setFirstName("First name");
		profile.setLastName("Last name");
		profileDAO.save(profile);

		
		 user.setProfile(profile);
		// userDAO.save(user);
		 
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
