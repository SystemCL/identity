package md.utm.entity.model.dao;

import java.util.List;

import md.utm.entity.model.entity.Message;

public interface MessageDAO extends GenericDAO {

	List<Message> getMessagesBySenderId();

	List<Message> getMessagesForConversation(Integer idReceiver);

	Message getMessageById(Integer idMessage);

	Message createAMessage(Message idMessageSender, Integer idReceiver);

}
