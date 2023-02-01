package stringconcatenation;

public class StringBuilderx {

    public static void main(String[] args) {
        // String str = "";
        final long startTime = System.currentTimeMillis();
        StringBuilder str = new StringBuilder();
        for(int i=1; i<=100000; i++){
            str.append("x");

        }
        System.out.println(str);

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    
}
