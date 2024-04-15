import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();

    public static void main(String[] args) {
        System.out.println("------------------- Westminster On line Shopping System -------------------");
        System.out.println("1 - Westminster Shopping Management System");
        System.out.println("2 - Graphical User Interface");
        System.out.println("3 - Exit");
        System.out.println();


        int option;
        System.out.print("Select option here: ");

        option = scn.nextInt();

        switch (option){
            case 1:
                System.out.println();
                westminsterShoppingManager.menuDisplay();
                break;
            case 2:
                new GUI();
                break;
            default:
                System.out.println("Invalid Input!");
        }
    }
}