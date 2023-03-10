package coffeeShop;

public class Beverage {
    private String productName;
    private int price;
    private String size;
    private String type;

    public Beverage(String productName, int price, String size, String type) {
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
