package product;

public class Laptop extends Product implements Printable {
    private String brand;
    private int RAM;

    public Laptop(String name, int price, String brand, int RAM) {
        super(name, price);
        this.brand = brand;
        this.RAM = RAM;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    @Override
    public void print() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Brand: " + brand + ", RAM: " + RAM);
    }

}
