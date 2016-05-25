package md.utm.entity.model.dao;

import java.util.List;

import md.utm.entity.model.entity.Profile;

public interface ProfileDAO extends GenericDAO {

	/**
	 * Returneaza o lista de profile in care a conversat cu profilul nostru.
	 */
	List<Profile> getProfilesWhoConversedWithMe();
	List<Profile> getAllProfilesBySearch();
 
	Profile getSesionProfile();

	void createProfile(Profile profile);

	Profile findProfileById(Integer userProfileId);
	
	String addFriendWithId(Integer idProfile);
	
	Profile createFriend(Profile idFriend);
	
	Profile createFriend();

}
