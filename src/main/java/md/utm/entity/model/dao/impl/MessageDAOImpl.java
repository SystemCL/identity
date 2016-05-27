package md.utm.entity.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import md.utm.entity.exception.NullProfileException;
import md.utm.entity.model.dao.MessageDAO;
import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Message;

@SuppressWarnings("unchecked")
public class MessageDAOImpl extends GenericDAOImpl implements MessageDAO {
	@Autowired
	private ProfileDAO profileDAO;

	
	public List<Message> getMessagesBySenderId() {

		Integer idProf = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (idProf == null) {
			throw new NullProfileException();
		}

		// trebuie de adus din sesiune id-ul la sender !!!!!!!!!!!!!!!!!!!
		// select ms from Message ms where ms not in (select u from Message u
		// join
		// u.profile_messages p where p.id=?)
		return getHibernateTemplate().find("from Message m join m.profiles pm where pm.profile_id=? and m.idSender=? limit 2",
				idProf, 2);

		// getHibernateTemplate().find("from Message where idSender=1 AND
		// idMessage in (Select idMessage from profile_messages where
		// profile_id=?)",idProf);
		/*
		 * return getHibernateTemplate().find(
		 * "from Message where idSender=1 AND idMessage in (Select idMessage from profile_messages where profile_id="
		 * +idProf+")");
		 */
		// getHibernateTemplate().find("from Message where idSender=?"
		// +idSender+ "AND idMessage in (Select idMessage from profile_messages
		// where profile_id=1)");
		/* ?"+idProf+")"); */
	}

	
	public Message getMessageById(Integer idMessage) {
		// TODO Auto-generated method stub
		return get(Message.class, idMessage);
	}

	
	public List<Message> getMessagesForConversation(Integer idReceiver) {

		Integer myId = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (myId == null) {
			return new ArrayList<Message>();
		}

		Query createQuery = getSession()
				.createQuery("from Message where  idSender in (:myid, :profileId)  and idReceiver in (:myid, :profileId)  order by idMessage asc, creationDate desc");
		createQuery.setInteger("profileId", idReceiver);
		createQuery.setInteger("myid", myId);
		 createQuery.setMaxResults(5);
		createQuery.list();
		return createQuery.list();
		
		// select * from Message where idSender=? and where idMessage=
		// ( message_id from profile_message where profile_id = [profilul meu])
		// aduc doate mesajele de la senderul dat unde se contine in tabela
		// intermediara
		// id- pentru meu - adica mesajele destinate mie

		// return getHibernateTemplate().find("from Message where idSender=?",
		// idProfile);

		// return getHibernateTemplate().find("from Message ");

	//	return getHibernateTemplate().find(
		//		"select m from Message m join m.profiles pm where pm.idProfile=? or m.idSender=?", myId, idProfile); /*and*/

		
/*		Integer myid = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (myid == null) {
			throw new NullProfileException();
		}
		Query createQuery = getSession()
				.createQuery("from message where idSender=:profileId and idMessage=: (select message_id from profile_messages where profile_id=:myid)");
		createQuery.setInteger("profileId", idProfile);
		createQuery.setInteger("myid", myid);
		 createQuery.setMaxResults(5);
		createQuery.list();
		return createQuery.list();*/
	}

	
	@Transactional
	public Message createAMessage(Message message, Integer idReceiver) {

		Integer myId = (Integer) ActionContext.getContext().getSession().get("profile_id");
		if (myId == null) {
			//return new ArrayList<Message>();
		}
		message.setCreationDate(new Date());
		message.setIdSender(myId);
		message.setIdReceiver(idReceiver);
		//message.getProfiles().add(profileDAO.getSesionProfile());
		save(message);
		return message;
	}



}