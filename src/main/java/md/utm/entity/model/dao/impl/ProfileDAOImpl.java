package md.utm.entity.model.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.exception.NullProfileException;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class ProfileDAOImpl extends GenericDAOImpl implements ProfileDAO {
	@Autowired(required = true)
	private UserDAO userDAO;

	
	public List<Profile> getProfilesWhoConversedWithMe() {

		Integer idProf = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (idProf == null) {
			throw new NullProfileException();
		}
		// System.out.println("id-ul pentru profil din sesiune = " + test);

		/*------ in implementat subquery pentru hibernate ------
		 * 
		 SELECT * FROM profile WHERE idProfile IN (
		 SELECT DISTINCT  idSender from message WHERE idMessage IN
		 (SELECT message_id FROM profile_messages WHERE profile_id =1)) ORDER BY firstname asc
		 * */

		return getHibernateTemplate().find("from Profile");

	}

	
	public Profile getSesionProfile() {
		Integer profileId = (Integer) ActionContext.getContext().getSession().get("profile_id");
		Profile profile = null;
		if (profileId != null)
			profile = get(Profile.class, profileId);
		return profile;
	}

	
	@Transactional
	public void createProfile(Profile profile) {
		save(profile);
		UserAccount findUser = userDAO.findUser((Integer) ActionContext.getContext().getSession().get("user_id"));
		findUser.setProfile(profile);
		ActionContext.getContext().getSession().put("profile_id", profile.getIdProfile());
		userDAO.update(findUser);
	}

	
	public Profile findProfileById(Integer userProfileId) {
		return get(Profile.class, userProfileId);

	}
	

	public List<Profile> getAllProfilesBySearch() {
		// TODO Auto-generated method stub
		return get(Profile.class);
	}

}
