package md.utm.entity.model.entity.impl;

import md.utm.entity.model.entity.MsgResp;

public abstract class MessInfo implements MsgResp {
	
	public char name;
	public char surname;

	
	public abstract int  getName() ;
}
