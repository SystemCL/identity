package md.utm.entity.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Comment extends MessageAbstract  {
	private Integer idMessage;
	private int pozitiveRating;
	private int negativeRating;
	private Profile profile;

	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage= idMessage;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name = "comment_id")
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public int getPozitiveRating() {
		return pozitiveRating;
	}

	public void setPozitiveRating(int pozitiveRating) {
		this.pozitiveRating = pozitiveRating;
	}

	public int getNegativeRating() {
		return negativeRating;
	}

	public void setNegativeRating(int negativeRating) {
		this.negativeRating = negativeRating;
	}

	public int incrementRating(int idComment) {
		return pozitiveRating++;
	}

	public int decrementRating(int idComment) {
		return negativeRating--;
	}

	public boolean commentProfile(String comment) {
		return false;
	}

}
