package md.utm.entity.model.dao.impl;

import java.util.List;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.exception.ObjectsNotFoundException;
import md.utm.entity.model.entity.UserAc;


@SuppressWarnings("unchecked")
public class UserDAOImpl extends GenericDaoImpl implements UserDAO {
	public UserAc findUser(String login, String password) {
		List<UserAc> find = getHibernateTemplate().find(
				"from UserAc where username=? and password=?", login, password);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(UserAc.class, login, password);
		}
		return find.iterator().next();
	}

	public List<UserAc> getAllUsers() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from UserAc order by username asc");
	}

	public UserAc findUser(Integer idAccount) {
		// TODO Auto-generated method stub
		return get(UserAc.class, idAccount);
	}

	public void deleteUser(Integer idAccount) {
		delete(findUser(idAccount));
		
	}

}
