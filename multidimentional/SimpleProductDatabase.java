package multidimentional;
import java.util.ArrayList;

public class SimpleProductDatabase {
    public static void main(String[] args) {
       ArrayList<String> dynamicArray = new ArrayList<String>();
       dynamicArray.add("Mitsubishi Adventure:800000");
       dynamicArray.add("Brewed Coffee:110");
       dynamicArray.add("Candy bar:50");

       for(String i : dynamicArray) {
        // System.out.println(i);
        String[] splitArr = i.split(":");
        System.out.println("Product: " + splitArr[0] + ", Price: " + splitArr[1]);
       }
        
    }
}
