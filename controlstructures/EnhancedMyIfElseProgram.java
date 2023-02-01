package controlstructures;

public class EnhancedMyIfElseProgram {
    public static void main(String[] args) {
        int n;
        for(n=0; n<=20; n++){
            if(n==0){
                System.out.println("First one: " + n);
            }
            else if(n < 5){
                System.out.println("Less than five " + n);
            }
            else if(n == 10 || n == 11){
                System.out.println("Ten or Eleven: " + n);
            }
            else{
                System.out.println("Not less than five: " + n);
            }
        }
        
    }
}
