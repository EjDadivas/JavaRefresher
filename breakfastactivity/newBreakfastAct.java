package breakfastactivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class newBreakfastAct {

    //For the commands keysearch and keysearch
    static void search(String type, ArrayList<String> arrays, String name){
        String titleResults = "";
        String descriptionResults = "";
        int count = 0;
        for(String i : arrays) {
            String[] splitArr = i.split(" : ");
            if(type == "key"){
            if(name.equals(splitArr[0])){
                count++;
                titleResults = "Found title: " + splitArr[0] + " | Results: " + count;
                        if(count != 0){
                            System.out.println(titleResults);
                        } else {
                            System.out.println("No title Found");
                        }
                    }
                    
                }
            else if(type == "description"){
            if(name.equals(splitArr[1])){
                count++;
                descriptionResults = "Found description: " + splitArr[1] + " | Results: " + count;
                    if(count != 0){
                        System.out.println(descriptionResults);
                    } else {
                        System.out.println("No description Found");
                    }
                }
            } else {
                System.out.println("Invalid Command");
            }
        }
    }
    public static void main(String[] args) {
    while(true){
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("[display/sort asc/sort desc/count/keysearch/dsearch/quit]");
        String parameter = sc.nextLine();

        ArrayList<String>arrays = new ArrayList<String>();
        arrays.add("Orange : Fruit");
        arrays.add("Banana : Fruit");
        arrays.add("Tomato : Vegetable");
        arrays.add("Tomato : Soup");

        
        //display the whole list
        if("display".equalsIgnoreCase(parameter)){
            for(String items : arrays){
                System.out.println(items);
            }
        // displays list in ascending order
        } else if("sort asc".equalsIgnoreCase(parameter)){
            Collections.sort(arrays);
            for(String items : arrays){
                System.out.println(items);
            }
        // displays list in descending order
        } else if("sort desc".equalsIgnoreCase(parameter)){
            Collections.reverse(arrays);
            for(String items : arrays){
                System.out.println(items);
            }
        // displays number of items in the list
        } else if("count".equalsIgnoreCase(parameter)){
            System.out.println("Size: " + arrays.size());
        // searches for title
        } else if(parameter.startsWith("keysearch ")){
            String title = parameter.substring("keysearch ".length());
            search("key", arrays, title);
        // searches for description
        } else if(parameter.startsWith("dsearch ")){
            String description = parameter.substring("dsearch ".length());
            search("description", arrays, description);
        // if u quit u quit
        } else if("quit".equalsIgnoreCase(parameter)){
            break;
        } else {
            System.out.println("Invalid Command!");
        }
            
        }
       
    }

}
