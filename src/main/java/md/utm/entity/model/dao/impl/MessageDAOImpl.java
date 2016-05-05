package md.utm.entity.model.dao.impl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.UserDAO;
import md.utm.entity.model.entity.Comment;
import md.utm.entity.model.entity.Message;

@SuppressWarnings("unchecked")
public class MessageDAOImpl extends GenericDAOImpl implements MessageDAO {

	public List<Message> getMessagesBySenderId() {
		
		Integer idProf;
		Map session = ActionContext.getContext().getSession(); 
		idProf = (Integer)session.get("profile_id");
		
		// trebuie de adus din sesiune id-ul la sender !!!!!!!!!!!!!!!!!!!
		return getHibernateTemplate().find("from Message");
				
				//getHibernateTemplate().find("from Message where idSender=1 AND idMessage in (Select idMessage from profile_messages where profile_id=?)",idProf);
		/*return getHibernateTemplate().find("from Message where idSender=1 AND idMessage in (Select idMessage from profile_messages where profile_id="+idProf+")");*/
				//getHibernateTemplate().find("from Message where idSender=?" +idSender+ "AND idMessage in (Select idMessage from profile_messages where profile_id=1)");
		/*?"+idProf+")"); */
	}

	public Message getMessageById(Integer idMessage) {
		// TODO Auto-generated method stub
		return get(Message.class, idMessage);
	}

	public List<Message> getMessagesForConversation(Integer idProfile) {
		
		Integer idProf;
		Map session = ActionContext.getContext().getSession(); 
		idProf = (Integer)session.get("profile_id");
		
		//select * from Message where idSender=? and where idMessage=
		//         ( message_id from profile_message where profile_id = [profilul meu])
		// aduc doate mesajele de la senderul dat unde se contine in tabela intermediara 
		// id- pentru meu - adica mesajele destinate mie
		
		//return getHibernateTemplate().find("from Message where idSender=?", idProfile);
		return getHibernateTemplate().find("from Message ");
	}
	
}