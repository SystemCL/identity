package md.utm.entity.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile {
	public String firstName;
	public String lastName;
	public Date dBirthday;
	public String location;
	public String status;
	public long picture;
	
	
	public List<Message> messageList;
	public List<Comment> commentList;
	public List<Announcement> announcementList;
	
	
	public int sendKnownRequest(int id){
		
		return 0;
		
	}
	
	public boolean reportProfile(int id){
		
		return false;
		
	}
	
	public boolean deleteKnown(int id){
		
		return false;
		
	}
	
	public boolean getMessages(){
		
		return false;
	}
	
	public boolean getComments(){
		
		return false;
	}
	
	public boolean getAnnouncement(){
		
		return false;
	}

}
