package JavaFunctions;

public class JavaFunctions {
    static float myFunction(float x){
        return(x/2);
    }
    public static void main(String[] args) {
        for(int x=0; x<10; x++){
            System.out.println("f(" + x + ") = " + myFunction(x));
        }
        
    }
}
