package md.utm.entity.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Message extends MessageAbstract {

	private int idMessage;
	private Integer idSender;
	private Set<Profile> profiles;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "profile_messages", joinColumns = @JoinColumn(name = "message_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))

	public Set<Profile> getProfiles() {
		if (profiles == null) {
			profiles = new HashSet<Profile>();
		}
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	public int getIdSender() {
		return idSender;
	}

	public void setIdSender(int idSender) {
		this.idSender = idSender;
	}

}
