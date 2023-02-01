package stringconcatenation;


public class StringConcatenation {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        String str = "";
        for(int i=1; i<=100000; i++){
            str += "x";
        }
        
        System.out.println(str);

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    
}
