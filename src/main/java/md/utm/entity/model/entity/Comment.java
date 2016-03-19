package md.utm.entity.model.entity;

import javax.persistence.Entity;

@Entity
public class Comment {
	
	public String messageContent;
	public int up;
	public int down;

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	
	public int up(int idComment){
		
		return 0;
		
	}

	public int down(int idComment){
		
		return 0;
	}
	
	
	public boolean commentProfile(String comment){
		
		return false;
	}
}
