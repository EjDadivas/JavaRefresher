package product;

public class Motorcycle extends Product implements Printable {
    private String brand;
    private int speed;

    public Motorcycle(String name, int price, String brand, int speed) {
        super(name, price);
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void print() {
        System.out.println(
                "Name: " + getName() + ", Price: " + getPrice() + ", Brand: " + brand + ", Speed: " + speed + "mph");
    }
}
