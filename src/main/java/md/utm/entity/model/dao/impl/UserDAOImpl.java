package md.utm.entity.model.dao.impl;

import java.util.List;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.exception.ObjectsNotFoundException;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends GenericDAOImpl implements UserDAO {
	public UserAccount findUser(String username, String password) {
		List<UserAccount> find = getHibernateTemplate().find("from UserAccount where username=? and password=?",
				username, password);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(UserAccount.class, username, password);
		}
		return find.iterator().next();
	}

	public List<UserAccount> getAllUsers() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from UserAccount order by username asc");
	}

	public UserAccount findUser(Integer idAccount) {
		// TODO Auto-generated method stub
		return get(UserAccount.class, idAccount);
	}

	public void deleteUser(Integer idAccount) {
		delete(findUser(idAccount));

	}

	public Profile getUserProfile(Integer idProfile) {
		// TODO Auto-generated method stub
		
		 List find = getHibernateTemplate().find("from Profile where idProfile=?",idProfile );
		// System.out.println("info hibernate adusa = " + find.iterator().next());
		 Profile profile=null;
		 if(!find.isEmpty()){
			
			 profile=(Profile) find.iterator().next();
		 }
		 return profile;
		
	}

}
