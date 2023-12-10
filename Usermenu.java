package com.training.client;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.sql.SQLException;
import java.util.Scanner;

import com.training.dao.UsercheckDao;
import com.training.service.AdminList;
import com.training.service.Usercheckservice;

public class  Usermenu{
	Scanner sc;
	public Usermenu()
	{
		sc=new Scanner(System.in);
		//adminlist=new ArrayList<>();
	}
	public void searchq() throws SQLException {
		String choice="Y";
		int ch=0;
		while(choice.equals("Y"))
		{
		System.out.println("*********************************");
		System.out.println("*****************Welcome to User Page***********");

		System.out.println("1.List the product in the store for user");
		System.out.println("2.Search the product by product id");
		System.out.println("3.List of product by category");
		System.out.println("4.Search the product by Name");
		System.out.println("5.List the product by Price");
		System.out.println("6.Bill");
		System.out.println("7.Exit");
		System.out.println("*********************************");

		ch=sc.nextInt();
		//AdminList AM=new AdminList();
		Usercheckservice uc=new Usercheckservice();
		//UsercheckDao oo=new UsercheckDao();

		switch(ch)
		{
		case 1:
			
			uc.showproduct();
			
			//AM.store();
			break;
		case 2:
			uc.showproductbyid();
			break;
		case 3:
			uc.searchbycategory();
			//AM.CategoryName();
			break;
		case 4:
			uc.showproductbyname();
			break;
		case 5:
			uc.showprice();
			break;
		case 6:
			uc.addtocart();
			break;
		case 7:
			//System.exit(0);
			Userswitch m=new Userswitch();
			m.search();
			
		}
		System.out.println("Y/N");
		choice=sc.next();	
		}





	}
	//public void ListOfProductStore()
	//{
		
	//}
	public static void main(String args[]) throws SQLException {
		Usermenu mm=new Usermenu();
		mm.searchq();
	}
	}


