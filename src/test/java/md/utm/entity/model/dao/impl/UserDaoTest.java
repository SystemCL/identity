package md.utm.entity.model.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.UserAccount;

public class UserDaoTest {
@Autowired
public UserDAO userDao;
	@Test
	public void testFindUserInteger() {
		UserAccount findUser = userDao.findUser(1);
		findUser.getProfile();
	}

}
