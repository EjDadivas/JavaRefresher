package coffeeShop;

public class CoffeeShop {

    public static void main(String[] args) {
        Beverage coffee = new Beverage("Coffee", 3, "Small", "Hot");
        Beverage tea = new Beverage("Tea", 2, "Medium", "Hot");
        Beverage latte = new Beverage("Latte", 4, "Large", "Hot");
        Beverage smoothie = new Beverage("Smoothie", 5, "Medium", "Cold");
        Beverage juice = new Beverage("Juice", 3, "Small", "Cold");

        Pastry croissant = new Pastry("Croissant", 2, "Bakery");
        Pastry muffin = new Pastry("Muffin", 3, "Bakery");
        Pastry donut = new Pastry("Donut", 1, "Bakery");
        Pastry cake = new Pastry("Cake", 4, "Dessert");
        Pastry pastry = new Pastry("Pastry", 2, "Bakery");

        System.out.println("Order Details:");
        System.out.println("Beverage: " + coffee.getProductName());
        System.out.println("Size: " + coffee.getSize());
        System.out.println("Price: $" + coffee.getPrice());
        System.out.println();
        System.out.println("Pastry: " + croissant.getProductName());
        System.out.println("Price: $" + croissant.getPrice());
        System.out.println();

        int totalPrice = coffee.getPrice() + croissant.getPrice();
        System.out.println("Total Price: $" + totalPrice);
    }
}
