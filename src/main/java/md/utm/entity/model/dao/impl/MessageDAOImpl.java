package md.utm.entity.model.dao.impl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Message;

public class MessageDAOImpl extends GenericDAOImpl implements MessageDAO {

	public List<Message> getMessagesBySenderId(Integer idSender) {
		Integer idProf; 
		Map session = ActionContext.getContext().getSession(); 
		idProf = (Integer)session.get("profile_id");
		return getHibernateTemplate().find("from Message where idSender=?" +idSender+ "AND idMessage=(Select from profile_messages where profile_id ="+idProf+")");
	}
	
public List<Comment> getAllComments() {
		
		Integer idProf;
        Map session = ActionContext.getContext().getSession(); 
        idProf = (Integer)session.get("profile_id"); 
        //System.out.println("id-ul pentru profil din sesiune = " + test);
		
		return getHibernateTemplate().find("from Comment where profile_idProfile=? order by creationDate desc", idProf);
		
		//("from Profile where idProfile=?",idProfile 
	}
	

}
