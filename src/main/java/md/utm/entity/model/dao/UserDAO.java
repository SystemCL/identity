package md.utm.entity.model.dao;

import java.util.List;

import md.utm.entity.model.entity.UserAc;

public interface UserDAO extends GenericDao {
	//List<Book> retrieveAllUploadedUserBooks(User user);

	UserAc findUser(String username, String password);

	List<UserAc> getAllUsers();

	UserAc findUser(Integer idAccount);

	void deleteUser(Integer idAccount);

}
