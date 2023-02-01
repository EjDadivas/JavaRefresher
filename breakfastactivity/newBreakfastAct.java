package breakfastactivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class newBreakfastAct {

    public static void main(String[] args) {
        // String title = "Z";

        String titleResults = "";
        String descriptionResults = "";

        int titleCount = 0;
        int descriptionCount = 0;

        ArrayList<String>arrays = new ArrayList<String>();

        arrays.add("F : A");
        arrays.add("Z : F");
        arrays.add("Z : C");
        arrays.add("C : Z");

        System.out.println("Display " + arrays);

        Collections.sort(arrays);
        System.out.println("Sort: " + arrays);

        Collections.reverse(arrays);
        System.out.println("Sort Des: " + arrays);
        
        System.out.println("Size: " + arrays.size());

        Scanner titleInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter title:");
        String title = titleInput.nextLine();
        
        Scanner descriptionInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter description:");
        String description = descriptionInput.nextLine();
        
        for(String i : arrays) {
            // System.out.println(i);
            String[] splitArr = i.split(" : ");

            if(title.equals(splitArr[0])){
                titleCount++;
                titleResults = "Found title: " + splitArr[0] + "| Results: " + titleCount;
            }
            if(description.equals(splitArr[1])){
                descriptionCount++;
                descriptionResults = "Found description: " + splitArr[1] + "| Results: " + descriptionCount;
            }
            
        }

        if(titleCount != 0){
            System.out.println(titleResults);
        } else {
            System.out.println("No title Found");
        }

        if(descriptionCount != 0){
            System.out.println(descriptionResults);
        } else {
            System.out.println("No description Found");
        }
      }

}
