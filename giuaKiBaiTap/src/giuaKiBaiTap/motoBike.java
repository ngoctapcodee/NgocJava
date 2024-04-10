package giuaKiBaiTap;

public class motoBike extends vihicle {
protected double capacity;
	public motoBike(int iD, String brand, int pushlishYear, double price, String color, double capacity) {
		super(iD, brand, pushlishYear, price, color);
		this.capacity= capacity;
	}
@Override
public void showInfo() {
	super.showInfo();
	System.out.println("Capacity: "+capacity);
}
}
