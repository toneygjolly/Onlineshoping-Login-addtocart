package com.training.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.training.service.UserLIST;
import com.training.service.Usercheckservice;

public class Userswitch {
	Scanner sc;
	//Usercheckservice uc;
	public Userswitch() {
	sc=new Scanner(System.in);
	//uc=new Usercheckservice();
	}
	public void search() throws SQLException {
		String choice="Y";
		int ch=0;
		
		
		while(choice.equals("Y"))
		{
			System.out.println("1.new Registration");
			System.out.println("2.Admin login");
			System.out.println("3.Userlogin");
			ch=sc.nextInt();
			Usercheckservice checks=new Usercheckservice();
			AdminMenu menu=new AdminMenu();
			//UserLIST menu1=new UserLIST();
			while(choice.equals("Y")) {
				switch(ch) {
				case 1:
					checks.insert();
					System.out.println("you got 100 coins");
					System.out.println("you are sucessfully account created");
					System.out.println("*********************************");
					checks.userchck();
					break;
				case 2:
					checks.Admin();
					//menu.search();
					
					break;
				case 3:
					checks.userchck();
					//menu.search();
					break;
				case 4:
					System.exit(0);
					System.out.println("Y/N");
					break;
				}
				
		
				
				

//System.out.println("YES//NO");
//choice=sc.next();



		}
	}
	/*public static void main(String[]args) {
		Userswitch ussw=new Userswitch();
		ussw.search();
	}*/

}}
