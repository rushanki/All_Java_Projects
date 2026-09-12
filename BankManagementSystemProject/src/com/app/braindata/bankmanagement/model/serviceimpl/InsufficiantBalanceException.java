package com.app.braindata.bankmanagement.model.serviceimpl;

public class InsufficiantBalanceException extends Exception
{
public InsufficiantBalanceException(String message)
{
super(message);	
}
}
