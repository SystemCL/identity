package md.utm.entity.model.dao.impl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Profile;

public class ProfileDAOImpl extends GenericDAOImpl implements ProfileDAO {

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

	public Profile getProfileById(Integer idProfile) {
		return get(Profile.class, idProfile);
	}

}
