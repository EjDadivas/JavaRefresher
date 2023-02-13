package product;

import java.util.ArrayList;

public class StoreMain {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();

        productList.add(new Car("honda", 4000, "japan", "hondaCivic"));
        productList.add(new Car("Toyota", 3500, "Japan", "Camry"));
        productList.add(new Car("Ford", 5000, "USA", "Mustang"));
        productList.add(new Laptop("ROG", 1000, "asus", 8));
        productList.add(new Laptop("ThinkPad", 800, "Lenovo", 16));
        productList.add(new Laptop("Macbook Pro", 1500, "Apple", 32));
        productList.add(new Motorcycle("Harley Davidson", 7000, "USA", 750));
        productList.add(new Motorcycle("Yamaha", 6000, "Japan", 650));
        productList.add(new Motorcycle("Ducati", 8000, "Italy", 900));

        for (int n = 0; n < productList.size(); n++) {
            Product p = productList.get(n);
            System.out.println("---");
            if (p instanceof Printable) {
                ((Printable) p).print();
            }

            System.out.println("Complete details: " + p.toString());
            System.out.println("---");
            System.out.println("");
        }

    }
}
