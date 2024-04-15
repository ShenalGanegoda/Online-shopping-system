import java.io.Serializable;

public abstract class Product implements Comparable<Product> , Serializable { //Super class(Abstract)
    public String productID;
    public String productName;
    public int numberOfAvailableItems;
    public double price;

    public Product(String productID , String productName , int numberOfAvailableItems , double price) {
        this.productID = productID;
        this.productName = productName;
        this.numberOfAvailableItems = numberOfAvailableItems;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setNumberOfAvailableItems(int numberOfAvailableItems) {
        this.numberOfAvailableItems = numberOfAvailableItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }


    @Override
    public int compareTo(Product other) {
        return 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", numberOfAvailableItems=" + numberOfAvailableItems +
                ", price=" + price +
                '}';
    }
}
