package breakfastactivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class newBreakfastAct {

    public static void main(String[] args) {
    while(true){
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("[display/sort asc/sort desc/count/keysearch/dsearch/quit]");
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
        
        if("display".equalsIgnoreCase(parameter)){
            System.out.println("Display " + arrays);
        } else if("sort asc".equalsIgnoreCase(parameter)){
            Collections.sort(arrays);
            System.out.println("Sort: " + arrays);
        } else if("sort desc".equalsIgnoreCase(parameter)){
            Collections.reverse(arrays);
            System.out.println("Sort Des: " + arrays);
        } else if("count".equalsIgnoreCase(parameter)){
            System.out.println("Size: " + arrays.size());
        } else if(parameter.startsWith("search ")){
            title = parameter.substring("search ".length());
            if(titleCount != 0){
                System.out.println(titleResults);
            } else {
                System.out.println("No title Found");
            }
        } else if(parameter.startsWith("dsearch ")){
            description = parameter.substring("dsearch ".length());
            if(descriptionCount != 0){
                System.out.println(descriptionResults);
            } else {
                System.out.println("No description Found");
            }
        } else if("quit".equalsIgnoreCase(parameter)){
            break;
        } else {
            System.out.println("Invalid Command!");
        }
            


       
        }
       
    }

}
