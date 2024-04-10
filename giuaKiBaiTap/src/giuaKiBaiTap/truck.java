package giuaKiBaiTap;

public class truck extends vihicle {
private double loadWeight;
	public truck(int iD, String brand, int pushlishYear, double price, String color, double loadWeight) {
		super(iD, brand, pushlishYear, price, color);
		this.loadWeight= loadWeight;
	}
	@Override
public void showInfo() {
	super.showInfo();
	System.out.println("Load Weight: "+loadWeight);
}
}
