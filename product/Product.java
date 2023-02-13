package product;

class Product {
    private String name = null;
    private int price = 0;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String v) {
        name = v;
    }

    public int getPrice() {
        return (price);
    }

    public void setPrice(int v) {
        price = v;
    }

    public String toString() {
        return ("Product: " + name + "Price " + price);
    }

}
