package md.utm.entity.model.dao.impl;

import java.util.List;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.exception.ObjectsNotFoundException;
import md.utm.entity.model.entity.UserAccount;


@SuppressWarnings("unchecked")
public class UserDAOImpl extends GenericDaoImpl implements UserDAO {
	public UserAccount findUser(String username, String password) {
		List<UserAccount> find = getHibernateTemplate().find(
				"from UserAc where username=? and password=?", username, password);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(UserAccount.class, username, password);
		}
		return find.iterator().next();
	}

	public List<UserAccount> getAllUsers() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from UserAc order by username asc");
	}

	public UserAccount findUser(Integer idAccount) {
		// TODO Auto-generated method stub
		return get(UserAccount.class, idAccount);
	}

	public void deleteUser(Integer idAccount) {
		delete(findUser(idAccount));
		
	}

}
