package md.utm.entity.action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Profile;

public class ProfileAction extends ActionSupport implements ModelDriven<Profile> {

	private static final long serialVersionUID = 1L;
	private Profile profile;
	private ProfileDAO profileDAO;

	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	
	public Profile getModel() {
		profile = profileDAO.getSesionProfile();
		if (profile == null) {
			profile = new Profile();
		}
		return profile;
	}

	public String getUserProfile() {
		return Action.SUCCESS;
	}

	public String saveProfile() {
		profileDAO.createProfile(profile);
		return Action.SUCCESS;
	}

	public String updateProfile() {
		profileDAO.saveOrUpdate(profile);
		return Action.SUCCESS;
	}
}
