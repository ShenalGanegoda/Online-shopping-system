import java.util.Comparator;

public class ProductIDSort implements Comparator<Product> {
    // Separate class to compare productID for sort

    @Override
    public int compare(Product product1, Product product2) { // Overriding method to compare two object's values.
        return product1.getProductID().compareTo(product2.getProductID()); // Compares two values.
    }
}
