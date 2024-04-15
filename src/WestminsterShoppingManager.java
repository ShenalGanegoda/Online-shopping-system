import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager, Serializable {

    // Maintains the list of products in the system, for the managers use
    // Provides methods for the system manager defined in the console menu
    public Scanner scn = new Scanner(System.in);
    public static ArrayList<Product> systemProductList = new ArrayList<>(); // Array List to hold the systems all products.
    ArrayList<Product> electronicProductList = new ArrayList<>(); // Array list to hold Electronic product List.
    ArrayList<Product> clothingProductList = new ArrayList<>(); // Array list to hold Clothing product List.
    public int electronicProductCount; // Integer variable to hold the added Electronic product count.
    public int clothingProductCount; // Integer variable to hold the added Clothing product count.
    public int addedProductCount = 0; // Integer variable to hold all the added product count.

    public void menuDisplay() {
        boolean menuExitLoop = true; // Boolean value to control Menu Loops.
        while (menuExitLoop) {
            System.out.println();
            System.out.println("------------------- Westminster Shopping Management -------------------");
            System.out.println("Select option here:");
            System.out.println("1 - Add new product");
            System.out.println("2 - Delete a product");
            System.out.println("3 - Print the list of products");
            System.out.println("4 - Save in a file");
            System.out.println("5 - Read from file");
            System.out.println("6 - Exit program");
            System.out.print("\nChoose option here: ");
            int optionInput = scn.nextInt();

            switch (optionInput) {
                case 1:
                    addNewProduct(); // Method call - Add products
                    break;

                case 2:
                    deleteProduct(); // Method call - Delete products
                    break;

                case 3:
                    printListOfProducts(); // Method call - Print product list
                    break;

                case 4:
                    saveInFile(); // Method call - Save in file
                    break;

                case 5:
                    loadFromFile(); // Method call - Load from file
                    break;

                case 6: // Exit loop
                    System.out.println("Exiting program..");
                    menuExitLoop = false;
                    break;

                default:
                    System.out.println("Invalid Input\nEnter again..");
            }
        }
    }

    public void addNewProduct() { // Overridden method to add new product for the system.
        int productChoice;
        boolean exitInnerLoop = true;

            while (exitInnerLoop) {
                if (maximumProductCount > addedProductCount){
                    // Checks if the product count exceeds the maximum product count.
                    System.out.println();
                    System.out.println("1 - Add Electronic products");
                    System.out.println("2 - Add Clothing products");
                    System.out.println("3 - GO TO MENU");
                    System.out.print("Choose here: ");
                    productChoice = scn.nextInt();

                    switch (productChoice) {
                        case 1:
                            addElectronicProduct();
                            break;

                        case 2:
                            addClothingProducts();
                            break;

                        case 3:
                            exitInnerLoop = false; // Breaks the inner loop
                            break;

                        default:
                            System.out.println("Invalid Input\nEnter again..");
                    }

                } else {
                    System.out.println();
                    System.out.println("Product count Full..\nNote: Can't add more products to the system!");
                    exitInnerLoop = false; // Breaks the inner loop
                }

            }

    }

    @Override
    public void deleteProduct() { // Overridden method to delete product from the system.
        boolean exitLoop = true; // Boolean value to exit the while loop.
        String productID;
        int option;

        while (exitLoop){
            System.out.println();
            System.out.print("1 - Remove Items\n2 - GO TO MENU\nChoose here: ");
            option = scn.nextInt();

            switch (option){
                case 1:
                    System.out.println();
                    System.out.print("Enter product ID: ");
                    productID = scn.next();

                    for (int i = 0; i < systemProductList.size(); i++) { // Traversing through all products.
                        Product product = systemProductList.get(i);
                        if (product.getProductID().equals(productID)){ // Checks for the ProductID.
                            systemProductList.remove(i); // remove if above condition is true.
                            if (product instanceof Clothing){ // Checks if the removed object is a Clothing object
                                clothingProductCount--;
                                // Decrementing the Clothing product count after product removal.
                                System.out.println("Clothing product removed\nClothing products in the system: " + clothingProductCount);
                            } else if (product instanceof Electronics) {
                                // Checks if the removed object is a Electronic object
                                electronicProductCount--;
                                // Decrementing the Electronic product count after product removal.
                                System.out.println("Electronic product removed\nElectronic products in the system: " + electronicProductCount);
                            }
                            addedProductCount--; // Decrementing the added product count after product removal.
                        } else System.out.println("Product ID does not match!\nEnter again.");
                    }
                    break;

                case 2: exitLoop = false; // Navigates to the menu.
                        break;

                default:
                    System.out.println("Invalid Input\nEnter again..");
            }
        }
    }

    @Override
    public void printListOfProducts() { // Overridden method to print out the product list in the system.
        int option;
        boolean exitLoop = true; // Boolean value to exit the while loop.

        while (exitLoop){
            System.out.println();
            System.out.print("1 - Print Electronic products\n2 - Print Clothing products\n3 - Print all " +
                    "products\n4 - GO TO MENU\nChoose list to print here: ");
            option = scn.nextInt();
            switch (option){
                case 1:
                    System.out.println("Electronic products list: ");
                    Collections.sort(electronicProductList , new ProductIDSort());
                    for (int i = 0; i < electronicProductList.size(); i++) { // Printing out Electronics product list.
                        System.out.println("Product " + (i + 1) + ": " + electronicProductList.get(i));
                    }
                    System.out.println("Electronic products in the system: " + electronicProductCount);
                    break;
                case 2:
                    System.out.println("Clothing products list: ");
                    Collections.sort(clothingProductList , new ProductIDSort());
                    for (int i = 0; i < clothingProductList.size(); i++) { // Printing out Clothing product list.
                        System.out.println("Product " + (i + 1) + ": " + clothingProductList.get(i));
                    }
                    System.out.println("Clothing products in the system: " + clothingProductCount);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("All products(By added order): "); // Printing out all products.
                    Collections.sort(systemProductList , new ProductIDSort());
                    for (int i = 0; i < systemProductList.size(); i++) {
                        System.out.println("Product " + (i + 1) + ": " + systemProductList.get(i));
                    }
                    System.out.println("All products in the system: " + addedProductCount);
                    break;
                case 4:
                    System.out.println("NAVIGATING TO MENU..");
                    exitLoop = false; // Exiting the while loop
                    break;
                default:
                    System.out.println("Invalid Input\nEnter again..");
                    break;
            }
        }

    }

    @Override
    public void saveInFile() { // Overridden method to save products in file
        try {
            fileClearing("Products.txt"); // Method to clear file before storing.
            FileOutputStream fileOutputStream = new FileOutputStream("Products.txt");
            // Creates a file output stream for saving in Products.txt
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Creates a object stream to save objects in the specific output stream

            for (int i = 0; i < systemProductList.size(); i++) { // For loop to traverse through the Array of objects
                objectOutputStream.writeObject(systemProductList.get(i)); // Writing objects to the file
            }
        } catch (IOException e){ // Validating errors.
            e.printStackTrace(); // Prints stack trace(Records).
        }
    }

    public void loadFromFile() { // Method to load products from file
        try (FileInputStream fileInputStream = new FileInputStream("Products.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Read objects from the file and add them to the existing list
            while (fileInputStream.available() > 0) {
                Object obj = objectInputStream.readObject();
                systemProductList.add((Product) obj);
                addedProductCount++;
                if (obj instanceof Clothing) {
                    clothingProductList.add((Clothing) obj);
                    clothingProductCount++;
                }
                if (obj instanceof Electronics) {
                    electronicProductList.add((Electronics) obj);
                    electronicProductCount++;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle exceptions according to your application's needs
        }
    }

    public void addElectronicProduct(){ // Separate method to add Electronic products as objects to Array List
        // Inputs to pass into the constructor for object creating.
        String productID; String productName; int numAvailableItems = 0; double productPrice = 0.0; String productBrand; int warrantyPeriod = 0;

        System.out.println();
        Product electronic = new Electronics(getValidProductID() , getValidProductName() , getValidNumberOfItems() ,
                getValidPrice() , getValidBrand() , getValidWarrantyPeriod());
        // Passing the inputs with validations with separate methods into the constructor
        // Creating an Electronic Object to push into the relevant ArrayList.

        electronicProductList.add(electronic); // Adding the created object to the Array list of 'Product'.
        systemProductList.add(electronic); // Adding the created object to all products array.

        electronicProductCount++; // Incrementing product count after creating Electronic object.
        addedProductCount++; // Incrementing all product variable count after creating Clothing object.
    }

    public void addClothingProducts(){ // Separate method to add Clothing products as objects to Array List.
        // Inputs to pass into the constructor for object creating.
        String productID; String productName; int numAvailableItems = 0; double productPrice = 0.0; int productSize = 0;
        String productColor;

        System.out.println();
        Product clothing = new Clothing(getValidProductID() , getValidProductName() , getValidNumberOfItems() ,
                getValidPrice() , getValidSize() , getValidColor());
        // Passing the inputs with validations with separate methods into the constructor
        // Creating a Clothing Object to push into the relevant ArrayList.

        clothingProductList.add(clothing); // Adding the created object to the Array list of 'Product'.
        systemProductList.add(clothing); // Adding the created object to all products array.

        clothingProductCount++; // Incrementing product count after creating Clothing object.
        addedProductCount++; // Incrementing all product variable count after creating Clothing object.
    }

    public String getValidProductID(){ // Separate method to get the input of the Product ID
        String productID;
        System.out.print("Enter Product ID: ");
        productID = scn.next();
        return productID;
    }
    public String getValidProductName(){ // Separate method to get the input of the Product name
        String productName;
        System.out.print("Product name: ");
        productName = scn.next();
        return productName;
    }
    public int getValidNumberOfItems(){ // Separate method to get the input of the number of items with validation
        int validNumberOfItems = 0;
        boolean isValid = false; // Boolean value to control the loop

        while (!isValid){
            System.out.print("Enter Number of items: ");

            if (scn.hasNextInt()){
                validNumberOfItems = scn.nextInt();
                if (validNumberOfItems < 0) { // Checks if number of items in a positive number
                    System.out.println("Number should be a positive Integer.\nEnter again!");
                    isValid = false; // Setting boolean to false if not valid
                } else {
                    isValid = true; // Setting boolean to true if valid
                }
            } else {
                System.out.println("Number should be a Integer.\nEnter again!");
                scn.next(); // Clearing the input
            }

        }
        return validNumberOfItems;
    }
    public int getValidPrice(){ // Separate method to get the input of the price with validation
        int price = 0;
        boolean isValid = false; // Boolean value to control the loop

        while (!isValid){
            System.out.print("Enter price: ");

            if (scn.hasNextInt()){
                price = scn.nextInt();
                if (price < 0) { // Checks if price in a positive number
                    System.out.println("Price should be a positive Integer.\nEnter again!");
                    isValid = false; // Setting boolean to false if not valid
                } else {
                    isValid = true; // Setting boolean to true if valid
                }
            } else {
                System.out.println("Price should be an Integer.\nEnter again!");
                scn.next(); // Clearing the input
            }

        }
        return price;
    }
    public int getValidSize(){ // Separate method to get the input of the size with validation
        int size = 0;
        boolean isValid = false; // Boolean value to control the loop

        while (!isValid){
            System.out.print("Enter size: ");

            if (scn.hasNextInt()){
                size = scn.nextInt();
                if (size < 0) { // Checks if size in a positive number
                    System.out.println("Size should be a positive Integer.\nEnter again!");
                    isValid = false; // Setting boolean to false if not valid
                } else {
                    isValid = true; // Setting boolean to true if valid
                }
            } else {
                System.out.println("Size should be an Integer.\nEnter again!");
                scn.next(); // Clearing the input
            }

        }
        return size;
    }
    public String getValidColor(){ // Separate method to get the input of the color with validation
        String color = "";
        boolean isValid = false; // Boolean value to control the loop

        while (!isValid){
            System.out.print("Enter color here: ");
            if (!scn.hasNextInt()) { // Checks if the input consists of Integers
                color = scn.next();
                isValid = true;
            } else {
                System.out.println("Input consists of Integer values\nEnter again!");
                isValid = false;
                scn.next(); // Clearing the input
            }
        }
        return color;
    }

    public int getValidWarrantyPeriod(){ // Separate method to get the input of the Warranty period with validation
        int warrantyPeriod = 0;
        boolean isValid = false; // Boolean value to control the loop

        while (!isValid){
            System.out.print("Enter Warranty period(Months): ");

            if (scn.hasNextInt()){
                warrantyPeriod = scn.nextInt();
                if (warrantyPeriod < 0) { // Checks if size in a positive number
                    System.out.println("Warranty period should be a positive Integer.\nEnter again!");
                    isValid = false; // Setting boolean to false if not valid
                } else {
                    isValid = true; // Setting boolean to true if valid
                }
            } else {
                System.out.println("Warranty period should be an Integer.\nEnter again!");
                scn.next(); // Clearing the input
            }

        }
        return warrantyPeriod;
    };

    public String getValidBrand(){ // Separate method to get the input of the Brand
        String brand;
        System.out.print("Brand: ");
        brand = scn.next();
        return brand;
    }

    private void fileClearing(String fileName) throws IOException {
        try(PrintWriter writer = new PrintWriter(fileName)){}
        // File creating if file name doesn't exist, clears if the file name exists.
    }

}
