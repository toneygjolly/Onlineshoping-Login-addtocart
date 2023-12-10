package com.training.client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.dao.UsercheckDao;
import com.training.service.AdminList;
import com.training.service.Usercheckservice;
public class AdminMenu {
Scanner sc;
//private List<UsercheckDao>adminlist;
public AdminMenu()
{
	sc=new Scanner(System.in);
	//adminlist=new ArrayList<>();
}
public void search() throws SQLException {
	String choice="Y";
	int ch=0;
	while(choice.equals("Y"))
	{
	System.out.println("*********************************");
	System.out.println("**********WELCOME TO ADMIN PAGE******************");

	System.out.println("1.List the product in the store");
	System.out.println("2.Search the product by product id");
	System.out.println("3.List of product by category");
	System.out.println("4.Search the product by Name");
	System.out.println("5.total amount spend on product");
	System.out.println("6.profit amount");
	//System.out.println("7.add the item");
	System.out.println("7.add the product");
	System.out.println("8.Exit");
	System.out.println("*********************************");

	ch=sc.nextInt();
	//AdminList AM=new AdminList();
	//itemvalues iv=new itemvalues();
	Usercheckservice uc=new Usercheckservice();
	
	switch(ch)
	{
	case 1:
		uc.showproduct();
		break;
	case 2:
		uc.showproductbyid();
		break;
	case 3:
		uc.searchbycategory();
		break;
	case 4:
		uc.showproductbyname();
		break;
	case 5:
		uc.totalsendamount();
		break;
	case 6:
		uc.profitoneachProduct();
		break;
	/*case 7:
		uc.itemvalues();
		break;*/
	case 7:
		uc.Productvalues();
		break;
	case 8:
		System.exit(0);
		
	}
	System.out.println("Y/N");
	choice=sc.next();	
	}





}
public void ListOfProductStore()
{
	
}
public static void main(String args[]) throws SQLException {
	AdminMenu mm=new AdminMenu();
	mm.search();
}
}
