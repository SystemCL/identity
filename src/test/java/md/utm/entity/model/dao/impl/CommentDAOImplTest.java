package md.utm.entity.model.dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDAOImplTest {
	@Autowired
	private CommentDAO testable;
	@Autowired
	private UserDAO userBean;

	@Test
	// @Transactional
	public void test() {
		Profile profile = new Profile();
		profile.setFirstName("First name");
		profile.setLastName("Last name");
		testable.save(profile);

		UserAccount account = new UserAccount();
		account.setAdmin(true);
		account.setProfile(profile);
		testable.save(account);

		Comment comment = new Comment();
		comment.setMessage("message");
		// comment.setProfile(profile);
		testable.save(comment);

		profile.getComment().add(comment);
		testable.update(profile);
	}

	@Test
	public void testComment() {
		List<UserAccount> allComments = userBean.getAllUsers();
		for (UserAccount userAccount : allComments) {
			System.out.println(userAccount.isAdmin());
			System.out.println(userAccount.getProfile().getFirstName());
			List<Comment> comments = userAccount.getProfile().getComment();
			for (Comment comment : comments) {
				System.out.println(comment.getMessage());
			}
		}
	}
}
