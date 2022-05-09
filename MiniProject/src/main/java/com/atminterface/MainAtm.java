package com.atminterface;


import java.sql.SQLException;
import java.util.Scanner;

public class MainAtm 
{
	     static AccountHolder op=new AccountHolder();
		 static Scanner sc=new Scanner(System.in);
 
	public static void main(String[] args) throws SQLException 
	{   
		System.out.println("enter the customer name");
		String name=sc.next();
		System.out.println("Enter the password");
		String psw=sc.next();
		boolean flag=op.loginpage(name, psw);
		if(flag) 
		{
			System.out.println("login is successfull");
			
		while(true)
		{
			System.out.println("**************SAFE ATM***************");
			System.out.println("1.VIEW BALANCE");
			System.out.println("2.WITHDRAW AMOUNT");
			System.out.println("3. DEPOSIT AMOUNT");
			System.out.println("4. RECEIPT");
			System.out.println("*************************************");
	        System.out.println("select the choice: ");
	        int choice=sc.nextInt();
	        switch(choice)
	        {
	        case 1: ATmOperation.check_balance();
	        break;
	        case 2: ATmOperation.withdraw_amount();
	        break;
	        case 3: ATmOperation.deposit_amount();
	        break;
	        default: System.out.println("invalid choice");
	        }//switch end
			
	        System.out.println("do u want to continue yes/no");
			String input=sc.next();  
			if(input.equalsIgnoreCase("no"))
			{
				
				break;
				
			}//if end
		}//if end
		}
			else
			{
				System.out.println("login failed,Try Again!");
				
			}//else end

			System.out.println("end the process!");
		}
	    	
 	}


