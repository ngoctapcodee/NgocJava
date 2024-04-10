package giuaKiBaiTap;

import java.io.Serializable;

public class vihicle implements ICar, Serializable {
	private static final long serialVersionUID = 1L;
protected int iD;
protected String brand;
protected int pushlishYear;
protected double price;
protected String color;
public vihicle(int iD, String brand, int pushlishYear, double price, String color) {
	this.iD= iD;
	this.brand= brand;
	this.pushlishYear= pushlishYear;
	this.price= price;
	this.color= color;
}
@Override
public void showInfo() {
	System.out.println("ID: "+iD);
	System.out.println("Brand: "+brand);
	System.out.println("pushlishYear: "+pushlishYear);
	System.out.println("price: "+price);
	System.out.println("color: "+color);
}
}
