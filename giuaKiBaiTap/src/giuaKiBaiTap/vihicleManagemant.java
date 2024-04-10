package giuaKiBaiTap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class vihicleManagemant {
public static String File_Name ="vihicle.txt";
public static void writeVihiclesToFile(List<vihicle> vi) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_Name))) {
        oos.writeObject(vi);
        System.out.println("Vihicles have been written to file.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static List<vihicle> readVihiclesFromFile() {
    List<vihicle> vi = null;
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(File_Name))) {
        vi = (List<vihicle>) ois.readObject();
        System.out.println("Vihicles have been read from file.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return vi;
}
public void addVihicle() {
	List<vihicle> vi = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Choose the type of employee to input:");
        System.out.println("1. Car");
        System.out.println("2. Moto Bike");
        System.out.println("3. Struck");
        System.out.println("4. Exit");

        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 4) {
            break;
        }

        switch (choice) {
            case 1:
                System.out.println("Enter information for Car vihicle:");
                vi.add(inputCar(scanner));
                break;
            case 2:
                System.out.println("Enter information for Motobike vihicle:");
                vi.add(inputMotoBike(scanner));
                break;
            case 3:
                System.out.println("Enter information for Truck vihicle:");
                vi.add(inputTruck(scanner));
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
        }
    }

    vihicleManagemant.writeVihiclesToFile(vi);

    List<vihicle> loadedVihicles = vihicleManagemant.readVihiclesFromFile();

    for (vihicle v : loadedVihicles) {
        v.showInfo();
        System.out.println();
    }
}

public static car inputCar(Scanner scanner) {
	System.out.println("Enter ID:");
    int ID = scanner.nextInt();
    System.out.println("Enter Brand:");
    String brand = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter Push Lish Year:");
    int pushlishyear = scanner.nextInt();
    System.out.println("Enter Price:");
    double price = scanner.nextDouble();
    System.out.println("Enter Color:");
    String color = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter Slots:");
    int slots = scanner.nextInt();
    System.out.println("Enter Engine Type:");
    String engineType = scanner.nextLine();
    
    try {
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLPT;user=sa;password=123");
		vihicleManagemant vhm = new vihicleManagemant();
		vhm.checkCar(con, ID, brand, pushlishyear, price, slots, engineType);
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    return new car(ID, brand, pushlishyear, price, color, slots, engineType);
}

public static motoBike inputMotoBike(Scanner scanner) {
	System.out.println("Enter ID:");
    int ID = scanner.nextInt();
    System.out.println("Enter Brand:");
    String brand = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter Push Lish Year:");
    int pushlishyear = scanner.nextInt();
    System.out.println("Enter Price:");
    double price = scanner.nextDouble();
    System.out.println("Enter Color:");
    String color = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter Capacity:");
    Double capacity = scanner.nextDouble();
    
    try {
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLPT;user=sa;password=123");
		vihicleManagemant vhm = new vihicleManagemant();
		vhm.checkMoto(con, ID, brand, pushlishyear, price, capacity);
	} catch (SQLException e) {
		e.printStackTrace();
	}

    return new motoBike(ID, brand, pushlishyear, price, color, capacity);
}

public static truck inputTruck(Scanner scanner) {
	System.out.println("Enter ID:");
    int ID = scanner.nextInt();
    System.out.println("Enter Brand:");
    String brand = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter Push Lish Year:");
    int pushlishyear = scanner.nextInt();
    System.out.println("Enter Price:");
    double price = scanner.nextDouble();
    System.out.println("Enter Color:");
    String color = scanner.nextLine();
    scanner.nextLine();
    System.out.println("Enter Load Weight:");
    Double loadWeight = scanner.nextDouble();
    
    try {
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLPT;user=sa;password=123");
		vihicleManagemant vhm = new vihicleManagemant();
		vhm.checkTruck(con, ID, brand, pushlishyear, price, loadWeight);
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    return new truck(ID, brand, pushlishyear, price, color, loadWeight);
}
private boolean checkCar(Connection con, int ID, String brand, int pushlishYear, double price, int slots, String engineType) {
	try {
	String sql = "SELECT * FROM car WHERE cID = ? AND cBrand = ? AND cpushlishYear=? AND cPrice=? AND cSlots=? AND cEngineType=?";
	try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, brand);
        preparedStatement.setInt(3, pushlishYear);
        preparedStatement.setDouble(4, price);
        preparedStatement.setInt(5, slots);
        preparedStatement.setString(6, engineType);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next();
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    return false;
}
}

private boolean checkMoto(Connection con, int ID, String brand, int pushlishYear, double price, double capacity) {
	try {
	String sql = "SELECT * FROM moto WHERE mID = ? AND mBrand = ? AND mpushlishYear=? AND mPrice=? AND mCapacity=?";
	try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, brand);
        preparedStatement.setInt(3, pushlishYear);
        preparedStatement.setDouble(4, price);
        preparedStatement.setDouble(5, capacity);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next();
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    return false;
}
}

private boolean checkTruck(Connection con, int ID, String brand, int pushlishYear, double price, double loadWeight) {
	try {
	String sql = "SELECT * FROM truck WHERE tID = ? AND tBrand = ? AND tpushlishYear=? AND tPrice=? AND tLoadWeight=?";
	try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, brand);
        preparedStatement.setInt(3, pushlishYear);
        preparedStatement.setDouble(4, price);
        preparedStatement.setDouble(5, loadWeight);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next();
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    return false;
}
}
}
