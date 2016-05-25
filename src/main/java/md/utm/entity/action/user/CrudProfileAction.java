package md.utm.entity.action.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Message;
import md.utm.entity.model.entity.Profile;

public class CrudProfileAction extends ActionSupport implements ModelDriven<Profile>, SessionAware {

	Profile profile ;//= new Profile();
	// User user = new User();
	private List<Profile> profileConversations;

	private Profile friend = new Profile();
	
	ProfileDAO profileDAO;
	private static Session session;
	private List<Profile> profileSearchList;

	private Integer idFriend;
	
	public Integer getIdFriend() {
		return idFriend;
	}

	public void setIdFriend(Integer idFriend) {
		this.idFriend = idFriend;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Profile> getProfileConversations() {
		return profileConversations;
	}

	public void setProfileConversations(List<Profile> profileConversations) {
		this.profileConversations = profileConversations;
	}

	public ProfileDAO getProfileDAO() {
		return profileDAO;
	}

	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	

	public String loadEditProfile() {
		return Action.SUCCESS;
	}

	public String getConversationUsersProfiles() {
		profileConversations = profileDAO.getProfilesWhoConversedWithMe();
		if (profileConversations == null) {
			profileConversations = new ArrayList<Profile>();
		}

		return Action.SUCCESS;

	}
	
	public String getProfilesSearch(){
		profileSearchList = profileDAO.getAllProfilesBySearch();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA "+profileSearchList);
		if(profileSearchList == null){
			profileSearchList = new ArrayList<Profile>();
		}
		
		return Action.SUCCESS;
		
	}
	
	

	
	public Profile getModel() {
		// TODO Auto-generated method stub
		return profile;
	}

	public String saveProfile() throws IOException, SQLException {

		profile.getIdProfile();
		profile.setFirstName("%{username}");
		profile.setLastName("%d{password}");
		// profile.setdBirthday(%{datepicker});
		profile.setLocation("%d{location}");
		profile.setStatus("%d{status}");
		profileDAO.save(profile);
		
		return Action.SUCCESS;
	}

	
	
	public List<Profile> getProfileSearchList() {
		return profileSearchList;
	}

	public void setProfileSearchList(List<Profile> profileSearchList) {
		this.profileSearchList = profileSearchList;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		CrudProfileAction.session = session;
	}

	
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}


   public String addFriend(){
	/*   friend = profileDAO.createFriend(profileDAO);
	   if(friend.getIdProfile() != null){
		   return Action.SUCCESS;
	   }
	   return Action.ERROR;
*/
	  // profileDAO.createFriend();
	   profileDAO.addFriendWithId(1);
	   
	   return Action.SUCCESS;
		
    }
	   
}
