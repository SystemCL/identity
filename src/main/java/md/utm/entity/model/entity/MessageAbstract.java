package md.utm.entity.model.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public abstract class MessageAbstract {
	
	public int idMessage;
	public String message;
	public Date dateMessage;
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateMessage() {
		return dateMessage;
	}
	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}


}
