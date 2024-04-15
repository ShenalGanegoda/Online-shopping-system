import java.io.Serializable;

public class Electronics extends Product { //Subclass of Product
    String brand;
    int warranty;

    public Electronics(){
        super("" , "" , 0 , 0.0);
    }
    public Electronics(String productID , String productName , int numberOfAvailableItems ,
                       double price , String brand , int warranty) {
        super(productID , productName , numberOfAvailableItems , price);
        // Passing in the values of the parent classes constructor using "super" keyword
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warranty=" + warranty +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", numberOfAvailableItems=" + numberOfAvailableItems +
                ", price=" + price +
                '}';
    }
}
