package breakfastactivity;
import java.util.Arrays;
import java.util.Collections;   

public class BreakfastActivity {
    public static void main(String[] args) {
    // new instance of arrayList, string objects
    String[] arrayList = {"xx: yy", "aa : bb", "Ej : Dadivas", "Rengar : Woof"};
    System.out.println("Display: " + Arrays.toString(arrayList));

    Arrays.sort(arrayList);
    System.out.println("Sort asc: " + Arrays.toString(arrayList));

    Arrays.sort(arrayList, Collections.reverseOrder());
    System.out.println("Sort desc: " + Arrays.toString(arrayList));
    
    System.out.println("Count: " + arrayList.length);
    // for(int i=0; i<arrayList.length; i++){
    //     System.out.println(arrayList[i]);
    // }

    
    // sortasc
    // sort desc
    // count
    // keysearch
    // dsearch
        
    }

}
