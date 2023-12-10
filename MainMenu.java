package com.training.client;

import java.sql.SQLException;

public class MainMenu extends Thread{
	public void run()
	{
		Userswitch users;
		try {
			 users=new Userswitch();
			 users.search();
			 Thread.sleep(100);
		}
		catch(SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
public static void main(String args[]) throws SQLException {
	MainMenu m=new MainMenu();
	m.start();
	try {
		m.join();
	}
	catch(InterruptedException ex) {
		ex.getMessage();
	}
	
	//Userswitch users=new Userswitch();
	//users.search();
	
}
}
