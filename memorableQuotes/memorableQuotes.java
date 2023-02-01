package memorableQuotes;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class memorableQuotes {
    static void createQuotes(ArrayList<String> quotes){
        quotes.add("Rise every time you fall.@EJ");
        quotes.add("Time every rise you fall.@Cass Lewis");
        quotes.add("Fall every time you rise.@Rengar The King");
        quotes.add("Every you timme fall rise.@Lewis Cass");
        quotes.add("Going Keep@Esther");
        quotes.add("Keep going@Ej Senpai");
    }
   
    static String getRandomQuote(ArrayList<String> quotes){    
        Random ran = new Random();
        int n = ran.nextInt(quotes.size());

        return(quotes.get(n));
    }

    static void printQuote(String quote){
            // System.out.println(i);
            String[] split = quote.split("@");
            System.out.println(split[0] + "\n -- " + split[1]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choose: [all/random]");
        String parameter = sc.nextLine();

        ArrayList<String> memorable = new ArrayList<String>();

        createQuotes(memorable);

        if(memorable.size() != 0) {
            if("all".equals(parameter)){
                
                for(String i : memorable){
                    System.out.println(i);
                    printQuote(i);
                }
                
            } else if("random".equals("random")){
                String myRandomQuote = getRandomQuote(memorable);
                System.out.println(myRandomQuote);
                printQuote(myRandomQuote);
            }

        } else {
            System.out.println("Error, No Quotes available");
        }
        
    }
            

}
