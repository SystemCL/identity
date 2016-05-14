package md.utm.entity.exception;

import org.apache.struts2.StrutsException;

public class NullProfileException extends StrutsException {
	public NullProfileException() {
		super("Before making any operation please complete your profile");
	}
}
