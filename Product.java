package com.pojo;

public class Product extends Item{
	private String catagory;
public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
private int productid;
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public double getSellingprice() {
	return sellingprice;
}
private double sellingpricea;

public double getSellingpricea() {
	return sellingpricea;
}
public void setSellingpricea(double sellingprice) {
	this.sellingprice= sellingprice;
}

public void setSellingprice(double sellingprice)
{
	
	this.sellingprice=sellingprice+(sellingprice*0.5);
}
public double getAvailableQuantity() {
	return availableQuantity;
}
public void setAvailableQuantity(double availableQuantity) {
	this.availableQuantity = availableQuantity;
}
private String productname;
private double sellingprice;
private double availableQuantity;
public Product(int productid,String productname,
		double sellingprice,double availableQuantity) {
	this.productid=productid;
	this.productname=productname;
	this.sellingprice=sellingprice;


	
}
public Product() {
	// TODO Auto-generated constructor stub
}
}
