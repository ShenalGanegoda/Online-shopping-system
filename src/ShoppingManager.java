import java.io.Serializable;

public interface ShoppingManager {
    public int maximumProductCount = 5; // Final variable to hold maximum products in the system.
    public void addNewProduct();
    public void deleteProduct();
    public void printListOfProducts();
    public void saveInFile();
}
