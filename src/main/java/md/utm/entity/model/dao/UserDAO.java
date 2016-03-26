package md.utm.entity.model.dao;

import java.util.List;

import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public interface UserDAO extends GenericDao {
	//List<Book> retrieveAllUploadedUserBooks(User user);
	
	
	
	UserAccount findUser(String username, String password);

	List<UserAccount> getAllUsers();

	UserAccount findUser(Integer idAccount);

	void deleteUser(Integer idAccount);
	
	Profile getUserProfile(Integer idUser);

}
