package md.utm.entity.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Message;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDAOImplTest {

	
	
	@Autowired
	private CommentDAO testable;
	private MessageDAO msDAO;
	@Autowired
	private UserDAO userBean;
	

	@Test
	@Transactional(readOnly = false)
	public void test() {

		UserDAOImpl userDaoImpl = (UserDAOImpl) userBean;
		SessionFactory sessionFactory = userDaoImpl.getSessionFactory();
		Session openSession = sessionFactory.getCurrentSession();
		Transaction transaction = openSession.beginTransaction();

		Profile profile = new Profile();
		profile.setFirstName("First name5");
		profile.setLastName("Last name5");
		testable.save(profile);

		UserAccount account = new UserAccount();
		account.setAdmin(true);
		account.setProfile(profile);
		testable.save(account);

		Comment comment = new Comment();
		comment.setMessage("message");
		comment.setProfile(profile);
		testable.save(comment);

		profile.getComment().add(comment);
		testable.update(profile);

		transaction.commit();
		// System.out.println(UserAccount.class.getName());
		// System.out.println(Profile.class.getName());
		// System.out.println(Comment.class.getName());
	}	
	
	
//	@Test
//	@Transactional(readOnly = true)
//	public void testMessage() {
//		List<Message> allMessages = msDAO.getMessagesBySenderId();
//		for (Message msg : allMessages) {
//			System.out.println(msg.idMessage);
//			System.out.println(msg.getMessage());
//			System.out.println(msg.getCreationDate());
//			
//			
//		}
//	}
	
	
	@Test
	@Transactional(readOnly = true)
	public void testComment() {
		List<UserAccount> allUssers = userBean.getAllUsers();
		for (UserAccount userAccount : allUssers) {
			System.out.println(userAccount.isAdmin());
			System.out.println(userAccount.getProfile().getFirstName());
			List<Comment> comments = userAccount.getProfile().getComment();
			for (Comment comment : comments) {
				System.out.println(comment.getMessage());
			}
		}
	}
	
}
	
	
