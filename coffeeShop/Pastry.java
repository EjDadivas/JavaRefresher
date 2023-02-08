package coffeeShop;

public class Pastry {
    private String productName;
    private int price;
    private String type;

    public Pastry(String productName, int price, String type) {
        this.productName = productName;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
