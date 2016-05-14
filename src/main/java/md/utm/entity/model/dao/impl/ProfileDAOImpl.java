package md.utm.entity.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class ProfileDAOImpl extends GenericDAOImpl implements ProfileDAO {
	@Autowired(required = true)
	private UserDAO userDAO;

	@Override
	public List<Profile> getProfilesWhoConversedWithMe() {

		Integer idProf;
		Map session = ActionContext.getContext().getSession();
		idProf = (Integer) session.get("profile_id");
		// System.out.println("id-ul pentru profil din sesiune = " + test);

		/*------ in implementat subquery pentru hibernate ------
		 * 
		 SELECT * FROM profile WHERE idProfile IN (
		 SELECT DISTINCT  idSender from message WHERE idMessage IN
		 (SELECT message_id FROM profile_messages WHERE profile_id =1)) ORDER BY firstname asc
		 * */

		return getHibernateTemplate().find("from Profile");

	}

	@Override
	public Profile getSesionProfile() {
		return get(Profile.class, (Integer) ActionContext.getContext().getSession().get("profile_id"));
	}

	@Override
	@Transactional
	public void createProfile(Profile profile) {
		save(profile);
		UserAccount findUser = userDAO.findUser((Integer) ActionContext.getContext().getSession().get("user_id"));
		findUser.setProfile(profile);
		userDAO.update(findUser);
	}

	@Override
	public Profile findProfileById(Integer userProfileId) {
		return get(Profile.class, userProfileId);

	}

}
