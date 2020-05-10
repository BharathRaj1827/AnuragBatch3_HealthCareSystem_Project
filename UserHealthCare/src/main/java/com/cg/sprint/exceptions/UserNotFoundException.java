package com.cg.sprint.exceptions;



public class UserNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg){
        super(msg);
    }

    public UserNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}