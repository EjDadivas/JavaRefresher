package linkedlist;
import java.util.LinkedList;

public class linkedList {
  public static void main(String[] args) {
    LinkedList<String> cars = new LinkedList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);

    for(String i : cars){
        System.out.println(i);
    }
  }

}