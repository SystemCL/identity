package md.utm.entity.action.user;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.dom4j.Document;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.CommentDAO;
import md.utm.entity.model.entity.Comment;

public class CrudCommentAction  extends ActionSupport implements ModelDriven<Comment>, SessionAware {
	private final Comment comment = new Comment();
	private CommentDAO commentDAO;
	
	
	private Boolean error;
	private Map<String, Object> sessionMap;

	private int idMessUpDown;

	
	 public int getIdMessUpDown() {
		return idMessUpDown;
	}



	public void setIdMessUpDown(int idMessUpDown) {
		this.idMessUpDown = idMessUpDown;
	}

	
	
	
	
	
@Override
public String execute()
{
	
	System.out.println("Date is  : " + this.idMessUpDown  + "Using S.O.P Method");
	sessionMap.put("idCommentToRate", 0);

 return SUCCESS;
// return null;	
}
	
	

	public Comment getModel() {
		return comment;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public String addComment() {
		comment.setCreationDate(new Date());
		commentDAO.save(comment);
		if (comment.getIdMessage() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
	
	
	public String rateUpComment(){
		
	//	System.out.println("Numarul==== " + sessionMap.get("idTest") + "===================");
		
		Comment comment1 = commentDAO.getCommentById(1);
		comment1.incrementRating(comment1.getIdMessage());//id comment trebuie de adus aici
	     commentDAO.update(comment1);
		
		
		
		//int numarC = Integer.parseInt("idM"); 
//		comment.setIdMessage(1);
//		comment.setMessage("treb sa fie tot acelasi");
//		comment.setCreationDate(new Date());
//		comment.incrementRating(1);//id comment trebuie de adus aici
//	     commentDAO.update(comment);
	   //  System.out.println("Ceva: " + this.idMessUpDown  + "dadadadadadadadad");
		
	     if (comment1.getIdMessage() != null) {
				return Action.SUCCESS;
			}
	     
		return Action.ERROR;
	}
	
	public String rateDownComment(){
		
		Comment comment1 = commentDAO.getCommentById(1);
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
