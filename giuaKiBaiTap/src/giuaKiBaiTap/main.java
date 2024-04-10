package giuaKiBaiTap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
    	while(true) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("1.Add vihicle");
        System.out.println("2.Delete vihicle");
        System.out.println("3.Edit information of vihicle");
        System.out.println("4. Read information of vihicle");
        System.out.println("5.Exit");
        
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        if(choice== 5) {
        	break;
        }
        switch(choice) {
        case 1:
        	vihicleManagemant vhm = new vihicleManagemant();
        	vhm.addVihicle();
        case 2:
        	
        case 3:
        	
        case 4:
        	
        default:
            System.out.println("Invalid choice. Please choose again.");
        }
    	}
    }
}