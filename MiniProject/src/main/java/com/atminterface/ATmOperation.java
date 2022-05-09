package com.atminterface;

import java.sql.SQLException;
import java.util.Scanner;

public class ATmOperation 
{
	 static AccountHolder op=new AccountHolder();
	 static Scanner sc=new Scanner(System.in);
	 

	public static void check_balance() throws SQLException 
	{
		int balance=op.getBalance(op.cid);
		System.out.println("YOUR CURRENT BALANCE IS: "+balance);
	        
		
	}

	public static void withdraw_amount() throws SQLException 
	{
		System.out.println("enter amount your want to withdraw: ");
		int amount=sc.nextInt();
	    boolean flag=op.withdraw(op.cid, amount);
	  
		if((flag&&amount<20000))
		{
			System.out.println("take your money: "+amount);
		
		}
		else
		{
			System.out.println("YOUR CARD MINI AMOUNT WITHDRAW IS ONLY 20000");
			System.out.println("**************************OR************************************");
			System.out.println("not enough money in your account!please check your account balance");
			
		}
	}

	public static void deposit_amount() throws SQLException 
	{
		System.out.println("enter amount you want to deposit:");
		int amount=sc.nextInt();
		boolean flag=op.deposit(op.cid, amount);
		if(flag)
		{
			System.out.println("successfully deposited money: "+amount);
			
		}
		
	}

}

	


