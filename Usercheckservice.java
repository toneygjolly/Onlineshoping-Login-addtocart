package com.training.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pojo.Item;
import com.pojo.Product;
import com.pojo.User;
import com.training.client.AdminMenu;
import com.training.dao.UsercheckDao;

public class Usercheckservice {
	//private List<Admin>Admincheck;
private List<User>usercheck;
private List<Item>Itemlist;
private List<Product>productlist; 
private List<Product>cart;
//private  Usercheckservice userch;
private UsercheckDao userch;
Scanner sc;
public Usercheckservice() {	
	//UsercheckDao=new userch();
	userch=new UsercheckDao();
	sc=new Scanner(System.in);
	//Admincheck=new ArrayList<Admin>();
	usercheck=new ArrayList<User>();
	Itemlist=new ArrayList<Item>();
	productlist=new ArrayList<Product>();
	cart=new ArrayList<Product>();
}




//user
public void insert() throws SQLException {
	System.out.println("enter the number of user want to add");
	int no=sc.nextInt();
	for(int i=0;i<no;i++) {
		User users=new User();
		System.out.println("Enter the username");
		users.setUsrname(sc.next());
		System.out.println("Enter the email id");
		users.setEmailid(sc.next());
		System.out.println("Enter the password");
		users.setPassword(sc.next());
		//System.out.println("supercoin need");
		users.setSuperCoins(100);
		//System.out.println("Enter the password");
		usercheck.add(users);
		
	}
	
	userch.insert(usercheck);
	

}
public void Admin() throws SQLException
{
	System.out.println("Enter the Adminname");
	String name=sc.next();
	System.out.println("Enter the password");
	String password=sc.next();
	//usercheck.userchck(name,password);
	//UsercheckDao.userchck(name,password);
	userch.Admin(name, password);
}

/*public void check() throws SQLException
{
	System.out.println("Enter the username");
	String name=sc.next();
	System.out.println("Enter the Password");
	String password=sc.next();
    boolean found=false;
	
	if(name.equals("admin") && password.equals("password"))
			{
		System.out.println("u are logined to admin page");
		AdminMenu menu=new AdminMenu();
		menu.search();
		
	}
	
	/*else {
		found = usercheck.stream().anyMatch(loginobj->loginobj.
				getUsrname().equals(name) && loginobj.
				getPassword().equals(password));
		if(!found) {
			System.out.println("u are logined to admin page");
		}
		else {
			System.out.println("u are not logined to userpage");

		}
		

	}*/


     /*int flag=0;

	 userlist.stream().allMatch(loginobj->loginobj.
			getUsrname().equals(name) && loginobj.
			getPassword().equals(password));
	if(flag==1) {
		System.out.println("u are logined to user");
	}
	else {
		System.out.println("u are not logined user");

	}*/
public void userchck() throws SQLException
{
	System.out.println("Enter the username");
	String name=sc.next();
	System.out.println("Enter the password");
	String password=sc.next();
	//usercheck.userchck(name,password);
	//UsercheckDao.userchck(name,password);
	userch.userchck(name, password);
}
//Admin
/*public void itemvalues() throws SQLException
{
	System.out.println("enter the number of item want to add");
	int no=sc.nextInt();
	for(int i=0;i<no;i++) {
		Item it=new Item();
		System.out.println("Enter the Itemname");
		it.setItemname(sc.next());
		System.out.println("Enter the Category");
		it.setCategory(sc.next());
		System.out.println("Enter the buyingprice");
		it.setBuyingprice(sc.nextDouble());
        Itemlist.add(it);
		

}

	userch.itemvalues(Itemlist);
}*/
public void Productvalues() throws SQLException
{

	System.out.println("enter the number of product want to add");
	int no=sc.nextInt();
	for(int i=0;i<no;i++) {
	Product pro =new Product();
	System.out.println("Enter the productid");
	pro.setProductid(sc.nextInt());
	System.out.println("Enter the productname");
	pro.setProductname(sc.next());
	//System.out.println("Enter the sellingprice");
	//pro.setSellingprice(sc.nextDouble());
	System.out.println("Enter the Catory");
	pro.setCatagory(sc.next());
	System.out.println("ENter the availableQuantity");
	pro.setAvailableQuantity(sc.nextDouble());
	System.out.println("Enter the buyingprice");
	double Price=sc.nextDouble();
	pro.setBuyingprice(Price);
	
	pro.setSellingprice(Price);
	productlist.add(pro);

	
	}
userch.Productvalues(productlist);
	}



public void displayi() throws SQLException {
	userch.displayi();
}
public void totalsendamount() throws SQLException {
	userch.totalsendamount();
}
public void profitoneachProduct() throws SQLException
{
	System.out.println("Enter the id which you need to check the profit");
	int id=sc.nextInt();
	userch.profitoneachProduct(id);
}
//user
////////////////////////////////////////////////////////////////////////
/*public void bill() throws SQLException
{
	System.out.println("enter the number of product want to buy");
	int no=sc.nextInt();
	for(int i=0;i<no;i++) {
	System.out.println("Enter the product that you want to buy");
	String productname=sc.next();
	//cart.bill(productname);
	userch.bill(productname);
	}
	
	
}*/
//user
public void addtocart() throws SQLException {
	System.out.println("Enter the username");
	String username=sc.next();
	userch.addtocart(username);
	
}
/*public void billgenerator() {
	System.out.println("****Bill*****");
	userch.billgenerator();
	
}*/
public void showproduct() throws SQLException
{
	System.out.println("the product values are");
	userch.showproduct();
}
public void showprice() throws SQLException
{
	System.out.println("low to high");
	userch.showprice();
}
public void searchbycategory() throws SQLException
{
	System.out.println("Enter the category");
	String category=sc.next();
	userch.searchbycategory(category);
}
public void showproductbyname() throws SQLException {
	System.out.println("Enter the product name which you want to check the product");
	String name =sc.next();
	userch.showproductbyname(name);
}
public void showproductbyid() throws SQLException
{
	System.out.println("Enter the id which you want to check the product");
	int id=sc.nextInt();
	userch.showproductbyid(id);
}

}

