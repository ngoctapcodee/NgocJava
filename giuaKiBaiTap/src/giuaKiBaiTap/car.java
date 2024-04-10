package giuaKiBaiTap;

public class car extends vihicle {
private int slots;
private String engineType;
	public car(int iD, String brand, int pushlishYear, double price, String color, int slots, String engineType) {
		super(iD, brand, pushlishYear, price, color);
		this.slots= slots;
		this.engineType= engineType;
	}
@Override
public void showInfo() {
	super.showInfo();
	System.out.println("Slots: "+slots);
	System.out.println("Engine Type: "+engineType);
}
}
