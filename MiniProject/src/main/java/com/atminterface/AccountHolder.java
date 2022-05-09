package com.atminterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AccountHolder
{
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;
	static int cid;
	static int balance=0;
	static String sql;
	static int i;
	static Scanner sc=new Scanner(System.in);
	public boolean loginpage(String name, String psw) throws SQLException
	{

		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		System.out.println("my connection"+scon);
		sql="select * from customer where cname='"+name+"' and cpass='"+psw+"'";
		rs=st.executeQuery(sql);
		if(rs.next())
		{
			//System.out.println(rs.getInt("cid"));
			cid=rs.getInt("cid");
			return true;
		}
		else
		{
			return false;
		}

	}
	public int getBalance(int id) throws SQLException
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		sql="select balanceamount from account where cid="+id;
		rs=st.executeQuery(sql);
		if(rs.next())
		{		
			balance=rs.getInt("balanceamount");
			return balance;
		}
		else
		{
			return 0;
		}
		

	}
	public boolean withdraw(int cid, int amount) throws SQLException
	{
		if((amount<balance&&amount<20000))
		{
			
			scon=Dbconnection.getConnection();
			st=scon.createStatement();
			sql="update account set balanceamount= "+(balance-amount)+" where cid="+cid;
			st.executeUpdate(sql);
			return true;
		}else
		{
			
			return false;
		}
		
	}
	public boolean deposit(int id, int amount) throws SQLException
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		sql="update account set balanceamount= "+(balance+amount)+" where cid="+id;
		i=st.executeUpdate(sql);
		if(i>0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	public void receipt(int id) throws SQLException
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		sql="select * from account where cid="+id;
		rs=st.executeQuery(sql);
		System.out.println("Account Type\tAccount Balance\tCustomer Id");
		if(rs.next())
		{
			System.out.println(rs.getString("accounttype")+" "+rs.getString("balanceamount")+" "+rs.getString("cid"));
		}
		else
		{
			System.out.println("ID is not found!");
		}
		
		
	}

}
