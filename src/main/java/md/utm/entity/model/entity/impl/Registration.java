package md.utm.entity.model.entity.impl;
public class Registration {
	
	public String newUserName;
	public String newUserLastname;
	public String newPassword;
	
	
	public boolean verifyEmailAddress(){
		
		return false;
	}
	
	public boolean verifyPhoto(){
		
		return false;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.newUserName;
	}
	
	

}
