package com.training.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.pojo.Item;
import com.pojo.Product;
import com.pojo.User;
import com.training.client.AdminMenu;
import com.training.client.Usermenu;
import com.training.connection.DataConnect;

import com.training.service.UserLIST;
import com.training.service.Usercheckservice;
public class UsercheckDao {
	private Connection con;
	double total=0.0;
	private PreparedStatement stat;
	//private List<com.pojo.Admin>Admincheck;
	private List<User>Usercheck;
	private List<Item>itemlist;
	private List<Product>productlist;
	private List<Product>cart;
	private static int temp;
	Scanner sc;
	public UsercheckDao()
	{
		//Admincheck=new ArrayList<com.pojo.Admin>();
		cart=new ArrayList<Product>();
		itemlist=new ArrayList<com.pojo.Item>();
		con=DataConnect.getConnection();
		Usercheck=new ArrayList<User>();
		productlist=new ArrayList<Product>();
		sc=new Scanner(System.in);
	}
	//User
 
	public void insert(List<User>Usercheck) throws SQLException {
	stat=con.prepareStatement("insert into user values(?,?,?,?)");
	for(User u:Usercheck)
	{
    stat.setString(1,u.getUsrname());	
    stat.setString(2,u.getEmailid());
    stat.setString(3,u.getPassword());
    stat.setInt(4,100);
	}
	int result=stat.executeUpdate();
	if(result>0)
	{
		System.out.println("Inserted suessfully");
		//Usercheckservice checks=new Usercheckservice();
		//checks.userchck();
	}
	else {
		System.out.println("invalid");
	}
	
	}
	
	public void Admin(String name,String password) throws SQLException {
		stat=con.prepareStatement("Select admin_name,password from Admins where admin_name='"+name+"'"
				+ "and password='"+password+"'");
		//boolean result=stat.execute();
	    ResultSet result1=stat.executeQuery();
		if(result1.next()) {
			System.out.println("welcome TO Admin page");
			//AdminMenu menu=new AdminMenu();
			//UserLIST menu1=new UserLIST();
			//Usermenu menu1=new Usermenu();
			//menu1.searchq();
			AdminMenu menu=new AdminMenu();
			menu.search();
		}
		else {
			System.out.println("invalid");
		}
	}
	public void userchck(String name,String password) throws SQLException {
		stat=con.prepareStatement("Select usrname,password from user where usrname='"+name+"'"
				+ "and password='"+password+"'");
		//boolean result=stat.execute();
	    ResultSet result1=stat.executeQuery();
		if(result1.next()) {
			System.out.println("welcome TO User page");
			//AdminMenu menu=new AdminMenu();
			//UserLIST menu1=new UserLIST();
			Usermenu menu1=new Usermenu();
			menu1.searchq();
		}
		else {
			System.out.println("invalid");
		}
	}
	//admin
	/*public void itemvalues(List<Item>itemlist) throws SQLException
	{
		stat=con.prepareStatement("insert into item	values(?,?,?)");
		for(Item i:itemlist)
		{
			stat.setString(1,i.getItemname());
			stat.setString(2,i.getCategory());
			stat.setDouble(3,i.getBuyingprice());
		}
		int result=stat.executeUpdate();
		if(result>0)
		{
			System.out.println("Inserted suessfully");
		}
		else {
			System.out.println("invalid");
		}
	}*/
	public void Productvalues(List<Product>productlist) throws SQLException
	{
		stat=con.prepareStatement("insert into Product values(?,?,?,?,?,?)");
		for(Product p:productlist)
		{
			stat.setInt(1,p.getProductid());
			stat.setString(2,p.getProductname());
			stat.setString(6,p.getCatagory());
			stat.setDouble(3,p.getSellingprice());
			stat.setDouble(4,p.getAvailableQuantity());
			stat.setDouble(5,p.getBuyingprice());
		}
		int result=stat.executeUpdate();
		if(result>0) {

			System.out.println("Inserted suessfully");
		}
		else {
			System.out.println("invalid");
		}
	}
	
	////////USER////////////////////////////////
	public void displayi() throws SQLException {
		stat=con.prepareStatement("select*from Product");
		ResultSet result=stat.executeQuery();
		while(result.next()) 
		{
			Product p=new Product();
			p.setProductid(result.getInt(1));
			p.setProductname(result.getString(2));
			p.setSellingpricea(result.getDouble(3));
			p.setAvailableQuantity(result.getDouble(4));
			p.setBuyingprice(result.getDouble(5));
			p.setCatagory(result.getString(6));
			productlist.add(p);
		/*	System.out.println("productid="+result.getInt(1));
			System.out.println("productname="+result.getString(2));
			System.out.println("sellingprice="+result.getDouble(3));
			System.out.println("availableQuantity="+result.getDouble(4));
			System.out.println("buyingprice="+result.getDouble(5));
			System.out.println("*********************************");*/

			
		}

	}
	public void showproductbyid(int id) throws SQLException {
		stat=con.prepareStatement("select*from Product where productid='"+id+"' ");
		ResultSet result=stat.executeQuery();
		if(result.next()) 
		{
			System.out.println("productid="+result.getInt(1));
			System.out.println("productname="+result.getString(2));
			System.out.println("sellingprice="+result.getDouble(3));
			System.out.println("availableQuantity="+result.getDouble(4));
			System.out.println("buyingprice="+result.getDouble(5));
			System.out.println("*********************************");	
		}
		else {
			System.out.println("check unsucessfully");
		}

	}
	public void searchbycategory(String category) throws SQLException {
		stat=con.prepareStatement("select*from Product where catagory='"+category+"'");
		ResultSet result=stat.executeQuery();
		/*if(!result.next())
		{
			System.out.println("no catagory found");
		}*/
		while(result.next()) 
		{
			System.out.println("productid="+result.getInt(1));
			System.out.println("productname="+result.getString(2));
			System.out.println("sellingprice="+result.getDouble(3));
			System.out.println("availableQuantity="+result.getDouble(4));
			System.out.println("buyingprice="+result.getDouble(5));
			System.out.println("*********************************");
		}
		
	}
	public void showproductbyname(String name) throws SQLException {
		stat=con.prepareStatement("select*from Product where productname='"+name+"' ");
		ResultSet result=stat.executeQuery();
		if(result.next()) 
		{
			System.out.println("productid="+result.getInt(1));
			System.out.println("productname="+result.getString(2));
			System.out.println("sellingprice="+result.getDouble(3));
			System.out.println("availableQuantity="+result.getDouble(4));
			System.out.println("buyingprice="+result.getDouble(5));
			System.out.println("*********************************");
		}
		else {
			System.out.println("check unsucessfully");
		}
	}
	public void showprice() throws SQLException
	{
		stat=con.prepareStatement("select*from Product order by sellingprice");
		ResultSet result=stat.executeQuery();
		while(result.next()) 
		{
			System.out.println("productid="+result.getInt(1));
			System.out.println("productname="+result.getString(2));
			System.out.println("sellingprice="+result.getDouble(3));
			System.out.println("*********************************");
		}
	}
	public void addtocart(String username) throws SQLException
	{
		stat=con.prepareStatement("select SuperCoins from user where usrname='"+username+"'");
		ResultSet result=stat.executeQuery();
		if(result.next()) 
		{
			System.out.println("SuperCoins"+result.getInt(1));
			temp=result.getInt(1);
		}
		displayi();
		String ch="Y";
		while(ch.equalsIgnoreCase("Y")) {
			System.out.println("Enter the product");
			String product=sc.next();
			boolean found=false;
			for(Product p:productlist)
			{
				if(p.getProductname().equalsIgnoreCase(product))
				{
					//System.out.println(p.getProductname());
					cart.add(p);
					found=true;
				}
			}
			if(!found)
			{
				System.out.println("no matching the product");
			}
			else
			{
				System.out.println("product add");
			}
			System.out.println("did you want to add or not to the cart");
			ch=sc.next();
		}
		double total=0.0;
		System.out.println("**BILL Generator**");
		for(Product c:cart)
		{
			System.out.println("product name ="+c.getProductname());
			System.out.println("price="+c.getSellingprice());
			//System.out.println("final");
			total=total+c.getSellingprice();
			System.out.println("the supercoin available is "+temp);
		}
		System.out.println("The totl amount is "+total);
		System.out.println("enter how many supercoins u need to use in denominations of 100");
		int supercoin=sc.nextInt();
		if(supercoin<=temp)
		{
			System.out.println();
			double temp1=(supercoin/100)*5;
			total=total-temp1;
		
			System.out.println("the total bill after discount is .."+total);
			stat=con.prepareStatement("UPDATE user set supercoins=? WHERE usrname=?");
			stat.setInt(1,temp-supercoin);
			stat.setString(2,username);
			//stat=con.prepareStatement("UPDATE Product set availableQuantity=availableQuantity-1 "
				//	+ "where productname=?");
			//stat.setString(1,product);
			
			stat.executeUpdate();
		}
		else
		{
			System.out.println("not enough supercoins available...");
			
		}
	}
	
	
	public void totalsendamount() throws SQLException {
		stat=con.prepareStatement("select buyingprice from Product");
		double total_send=0;
		ResultSet result=stat.executeQuery();
		while(result.next())
		{
			total_send=total_send+result.getDouble(1);
		}
		System.out.println("*********************************");

		System.out.println("Total amount spend"+total_send);
		System.out.println("*********************************");

	}
	public void profitoneachProduct(int id) throws SQLException {
		stat=con.prepareStatement("select sellingprice,buyingprice from Product where productid='"+id+"'");
		double profit=0;
		ResultSet result=stat.executeQuery();
		while(result.next()) 
		{
		profit=	result.getDouble(1)-result.getDouble(2);
		}
		System.out.println("*********************************");

		System.out.println("Total PROFIT  = "+profit);
		System.out.println("*********************************");

	}
	//USER DATA

	
	
	
	
	
	
	
	
	/*public void bill(String productname) throws SQLException
	{
	stat=con.prepareStatement("select sellingprice,productname from Product where productname='"+productname+"'");	
	double price=0;
	double gift=100;
	double total=0;
	double last=0;
	ResultSet result=stat.executeQuery();
	while(result.next()) 
	{
		System.out.println("sellingprice="+result.getDouble(1));
		System.out.println("productname="+result.getString(2));
		
		
		price=price+result.getDouble(1);
		System.out.println("Total amount is="+price);
		
		
	}
	System.out.println("After reduce the supercoin  you get");
	total=price-gift;
	System.out.println("after discount="+total);
	
	}*/
	
	
	
	
	
	
	

	
	
	
	
	public void showproduct() throws SQLException {
		stat=con.prepareStatement("select*from Product");
		ResultSet result=stat.executeQuery();
		while(result.next()) {
			System.out.println("*********************************");

			System.out.println("productid="+result.getInt(1));
			System.out.println("productname="+result.getString(2));
			System.out.println("sellingprice="+result.getDouble(3));
			System.out.println("availableQuantity="+result.getDouble(4));
			System.out.println("buyingprice="+result.getDouble(5));
			System.out.println("*********************************");
		}
		
	}
	
	
}