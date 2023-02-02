package memorableQuotes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class memorableQuotes {

    // for the quotes counter
    static Map<String, Integer> count = new HashMap<>();
    // 2. Adds quotes inside ArrayList 11. read files fromm a list
    static void createQuotes(ArrayList<String> quotes){
        try {
			List<String> allLines = Files.readAllLines(Paths.get("C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotes\\quotes.txt"));

			for (String line : allLines) {
                quotes.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
    // 1. Generates Random quotes
    static String getRandomQuote(ArrayList<String> quotes){    
        Random ran = new Random();
        int n = ran.nextInt(quotes.size());
        return(quotes.get(n));
    }
    //counts each time the quote is displayed
    static void incrementCount(String quote) {
        if (!count.containsKey(quote)) {
            count.put(quote, 0);
        }
        count.put(quote, count.get(quote) + 1);
    }
    // prints quotes in a new format
    static void printQuote(String quote) {
        incrementCount(quote);
        String[] split = quote.split("@");
        System.out.println(split[0] + " (" + count.get(quote) + ")" + "\n -- " + split[1]);
    }

    // Searches for both reference and content
    static void searchQuote(String type, ArrayList<String> quotes, String name){
        int count = 0;
        for(String i : quotes){
            String[] split = i.split("@");
            // search command: gives author
            if(type == "name"){
                if(split[1].contains(name)){
                    printQuote(i);
                    count++;
                } 
            }
            // csearch command: gives content
            if(type == "content"){
                if(split[0].contains(name)){
                    printQuote(i);
                    count++;
                } 
            }
            // category command: gives quotes with that category
            if(type == "category"){
                if(split[2].contains(name)){
                    printQuote(i);
                    count++;
                } 
            }
        }
        if(count != 0){
            System.out.println("Found " + count + " results");
        } else {
            System.out.println("No results found");

        }
    }
    // displays random quotes with delay and max quotes
    static void displayRandomQuote(ArrayList<String> quotes, String name){
        int delay = 3000, max = 0, x = 0;
        // for additional commands after display
        String[] split=name.split(" ");
        for(String i : split){
            String[] splitCommand = i.split("=");
                if("delay".equals(splitCommand[0])){
                    delay = 1000 * Integer.parseInt(splitCommand[1]);
                } else if("max".equals(splitCommand[0])){
                    max = Integer.parseInt(splitCommand[1]);
                } 
            }

        while(x < max){
            String quote = getRandomQuote(quotes);
            
            printQuote(quote);

            try{
                Thread.sleep(delay);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            x++;
        }
    }

    
    // Database Management Function:
    // Add, Delete, Modify
    // Add to file?
    static void database(ArrayList<String> quotes, String name){
        String[] split=name.split(" ");
        for(String i : split){
            String[] splitCommand = i.split("=");
                if("add".equals(splitCommand[0])){
                    add(splitCommand)
                }
            }
    }
    // Main Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Choose: [all/random/search/csearch/display/category/db/quit/]");
            String parameter = sc.nextLine();

            ArrayList<String> memorable = new ArrayList<String>();

            createQuotes(memorable);
            
                if(memorable.size() != 0) {
                    if("all".equals(parameter)){
                        for(String i : memorable){
                            printQuote(i);
                        }   
                    } else if("random".equals(parameter)){
                        String myRandomQuote = getRandomQuote(memorable);
                        printQuote(myRandomQuote);
                    } else if(parameter.startsWith("search ")){
                        String name = parameter.substring("search ".length());
                        searchQuote("name",memorable, name);
                    } else if(parameter.startsWith("csearch ")){
                        String name = parameter.substring("csearch ".length());
                        searchQuote("content",memorable, name);
                    } else if(parameter.startsWith("display ")){
                        String name = parameter.substring("display ".length());
                        displayRandomQuote(memorable, name);
                    }else if(parameter.startsWith("category ")){
                        String name = parameter.substring("category ".length());
                        searchQuote("category",memorable, name);
                    } else if("quit".equals(parameter)){
                        break;
                    }else{
                        System.out.println("Invalid command");
                    }

                } else {
                    System.out.println("Error, No Quotes available");
                    break;
                }
            
            
            }
                
        }
}
