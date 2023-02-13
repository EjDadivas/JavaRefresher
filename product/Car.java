package product;

public class Car extends Product implements Printable {
    private String make;
    private String model;

    public Car(String name, int price, String make, String model) {
        super(name, price);
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void print() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Make: " + make + ", Model: " + model);
    }
}
