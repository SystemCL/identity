package md.utm.entity.model.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.exception.NullProfileException;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class ProfileDAOImpl extends GenericDAOImpl implements ProfileDAO {
	@Autowired(required = true)
	private UserDAO userDAO;
	private ProfileDAO profileDAO;


	
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
		
		System.out.println("In profileDAOImpl");
		//Integer idProf = (Integer) ActionContext.getContext().getSession().get("profile_id");
		//if (idProf == null) {
		//	throw new NullProfileException();
		//}
		
/*		Query createQuery = getSession()
				.createQuery(" * from Profile"); //trebuie de adus profilurile, unde numele este introdus in textbox la search
		
	//	createQuery.setInteger("profileId", idProf);
		// createQuery.setMaxResults(1);
		createQuery.list();
		
		System.out.println(createQuery);
		return createQuery.list();*/
		
		return getHibernateTemplate().find("from Profile");
		
	}
	
	public String addFriendWithId(Integer idProfile){
		
		Integer myId = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (myId == null) {
			throw new NullProfileException();
		}
		
		
		Query createQuery = getSession().createQuery("insert into profile_friends (1 ,1)");
		//Query createQuery = getSession().createQuery("insert into profile_friends (idProfile,idProfile) select Profile.idProfile from Profile where idProfile =:myId, select Profile.idProfile from Profile where idProfile =:idProfile ");
		 
		//Query createQuery = getSession().createQuery("insert into profile_friends values (myId,friendId)");
		
		createQuery.setInteger("myId", myId);
	//	createQuery.setInteger("friendId", idProfile);
		int result = createQuery.executeUpdate();
		
		if(result!=0){
		 return Action.ERROR;	
		}
		
		return Action.SUCCESS;	
		
	}


	public Profile createFriend(Profile friend) {
		//friend.getProfiles().add(profileDAO.getSesionProfile());
		//friend.getFriendsList().add(profileDAO.getSesionProfile());
		//save(friend);
		Profile friendp = new Profile();
		friendp.setFirstName("ION");
		friendp.setLastName("TRTRRR");
		
		save(friendp);
		friend.getFriendsList().add(friendp);
		save(friend);
		
		return friend;
	}


	public Profile createFriend() {
		Profile friendp = new Profile();
		friendp.setFirstName("Vlad");
		friendp.setLastName("TRTRRR");
		
		save(friendp);
		friendp.getFriendsList().add(friendp);
		save(friendp);
		return null;
	}
	
	

}
