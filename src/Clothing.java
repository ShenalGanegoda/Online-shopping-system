
public class Clothing extends Product { //Subclass of Product
    int size;
    String color;
    public Clothing(String productID , String productName , int numberOfAvailableItems , double price , int size ,
                    String color) {
        super(productID , productName , numberOfAvailableItems , price);
        // Passing in the values of the parent classes constructor using "super" keyword
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", numberOfAvailableItems=" + numberOfAvailableItems +
                ", price=" + price +
                '}';
    }
}
