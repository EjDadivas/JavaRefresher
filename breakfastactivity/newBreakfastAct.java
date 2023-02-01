package breakfastactivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class newBreakfastAct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter title:");
        String parameter = sc.nextLine();
        String title = "";
        String description = "";
        String titleResults = "";
        String descriptionResults = "";

        int titleCount = 0;
        int descriptionCount = 0;

        ArrayList<String>arrays = new ArrayList<String>();
        arrays.add("Orange : Fruit");
        arrays.add("Banana : Fruit");
        arrays.add("Tomato : Vegetable");
        arrays.add("Tomato : Soup");

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
        switch(parameter){
            case "display":
            System.out.println("Display " + arrays);
            break;

            case "sort asc":
            Collections.sort(arrays);
            System.out.println("Sort: " + arrays);
            break;

            case "sort desc":
            Collections.reverse(arrays);
            System.out.println("Sort Des: " + arrays);
            break;

            case "count":
            System.out.println("Size: " + arrays.size());
            break;

            case "keysearch":
            title = sc.nextLine();
            if(titleCount != 0){
                System.out.println(titleResults);
            } else {
                System.out.println("No title Found");
            }
            break;

            case "dsearch":
            description = sc.nextLine();
            System.out.println(""); 
            if(descriptionCount != 0){
                System.out.println(descriptionResults);
            } else {
                System.out.println("No description Found");
            }
            break;
        }





       

       
      }

}
