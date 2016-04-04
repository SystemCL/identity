package md.utm.entity.action.user;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.dom4j.Document;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Profile;
import md.utm.entity.model.entity.UserAccount;

public class CrudCommentAction  extends ActionSupport implements ModelDriven<Comment>, SessionAware {
	private final Comment comment = new Comment();
	private CommentDAO commentDAO;
	private UserDAO userDAO;
	
	
	
	private Boolean error;
	private Map<String, Object> sessionMap;

	private int idMessUpDown;

	
	 public int getIdMessUpDown() {
		return idMessUpDown;
	}



	public void setIdMessUpDown(int idMessUpDown) {
		this.idMessUpDown = idMessUpDown;
	}	
	

	public Comment getModel() {
		return comment;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public String addComment() {
		
		// sessionMap.get("profile_id");
//		Profile profile = new Profile();
//		profile.setFirstName("First name");
//		profile.setLastName("Last name");
//		testable.save(profile);
//
//		UserAccount account = new UserAccount();
//		account.setAdmin(true);
//		account.setProfile(profile);
//		testable.save(account);
//
//		Comment comment = new Comment();
//		comment.setMessage("message");
//		// comment.setProfile(profile);
//		testable.save(comment);
//

		// merge
		Integer test;
        Map session = ActionContext.getContext().getSession(); 
        test = (Integer)session.get("profile_id"); 
        System.out.println("id-ul pentru profil din sesiune = " + test);
		
        Profile profile = new Profile();
        //profile = userDAO.getUserProfile(1);
        System.out.println("informatieeeee = " + userDAO.getUserProfile(1));
	
		
		comment.setCreationDate(new Date());
		comment.setProfile(profile);
		commentDAO.save(comment);
		
		profile.getComment().add(comment);
		userDAO.update(profile);
		
		//comment.setCreationDate(new Date());
		//commentDAO.save(comment);
		
		if (comment.getIdMessage() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
	
	
	public String rateUpComment(){
		
		Comment comment1 = commentDAO.getCommentById(idMessUpDown);
		comment1.incrementRating(comment1.getIdMessage());//id comment trebuie de adus aici
	     commentDAO.update(comment1);

		
	     if (comment1.getIdMessage() != null) {
				return Action.SUCCESS;
			}
	     
		return Action.ERROR;
	}
	
	public String rateDownComment(){
		
		Comment comment1 = commentDAO.getCommentById(idMessUpDown);
		comment1.decrementRating(comment1.getIdMessage());//id comment trebuie de adus aici
	     commentDAO.update(comment1);
		
		
	    // sessionMap.get("");
	     if (comment1.getIdMessage() != null) {
				return Action.SUCCESS;
			}
	     
		return Action.ERROR;
	}



	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
