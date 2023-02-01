package staticArray;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class JavaStaticArray {
    public static void main(String[] args) {
        Scanner valueInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter [normal/reverse]");
        String value = valueInput.nextLine();

        String[] strings;
        strings = new String[] {
            "First string",
            "Second string",
            "Third string",
            "Fourth string"
        };
        strings[0] = "Replaced first string";

        // Activity 1
        Arrays.sort(strings, Collections.reverseOrder()); 

        switch(value){
            case "normal":
                for(int n=0; n<strings.length; n++){
                    System.out.println(strings[n]);
                }
                break;
            case "reverse":
                Arrays.sort(strings, Collections.reverseOrder()); 
                for(int n=0; n<strings.length; n++){
                    System.out.println(strings[n]);
                }
                break;
            default:
                System.out.println("error");
        }
    }
}
