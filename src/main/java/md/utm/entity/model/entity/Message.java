package md.utm.entity.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Message extends MessageAbstract {
	
	public int idMessage;
	public int idProfile;
	public int idReceiver;
	public Set<Profile> profiles;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	
	//@ManyToMany(cascade = CascadeType.ALL, mappedBy = "profile")
	public int getIdSender() {
		return idProfile;
	}
	public void setIdSender(int idSender) {
		this.idProfile = idSender;
	}
	
	//@ManyToMany(cascade = CascadeType.ALL, mappedBy = "profile")
	public int getIdReceiver() {
		return idReceiver;
	}
	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}
	

/*	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="profile_messages", 
    joinColumns=@JoinColumn(name="idMessage"), 
    inverseJoinColumns=@JoinColumn(name="idProfile"))
	
*
*/
	@ManyToMany(targetEntity=md.utm.entity.model.entity.Profile.class, mappedBy="profile")
	public Set<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	
	

  

}
