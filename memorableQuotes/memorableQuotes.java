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
import java.io.FileWriter;
import memorableQuotes.QuotesFormatter;


public class memorableQuotes {

    private static QuotesFormatter quoteFormatter = new QuotesFormatter();
    // 2. Adds quotes inside ArrayList 11. read files fromm a list
    public static void createQuotes(ArrayList<String> quotes){
        int u = 0;
        try {
			List<String> allLines = Files.readAllLines(Paths.get("C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotes\\quotes.txt"));

			for (String line : allLines) {
                u++;
                quotes.add(u + ". " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
    // 1. Generates Random quotes
    public static String getRandomQuote(ArrayList<String> quotes){    
        Random ran = new Random();
        int n = ran.nextInt(quotes.size());
        return(quotes.get(n));
    }

    // prints quotes in a new format
    public static void printQuote(String quote) {
        // quoteFormatter.incrementCount(quote);
        String[] split = quote.split("@");
        System.out.println('"'+ split[0] +'"' + " (" + split[3] + ")" + "\n -- " + split[1]);

    }

    // Searches for both reference and content
    public static void searchQuote(String type, ArrayList<String> quotes, String name){
        int count = 0;
        for(String i : quotes){
            String[] split = i.split("@");
            
            // csearch command: gives content
            if(type == "content"){
                if(split[0].contains(name)){
                    printQuote(i);
                    count++;
                } 
            }  
            // search command: gives author
            if(type == "name"){
                if(split[1].contains(name)){
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
    public static void displayRandomQuote(ArrayList<String> quotes, String name){
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

    public static void add(ArrayList<String> quotes, String quote){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotes\\quotes.txt", true);
            fw.append("\n"+ quote);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Database Management Function:
    // Add, Delete, Modify
    // For database commands [add | modify | delete]
    public static void database(ArrayList<String> quotes, String name){
        Scanner input = new Scanner(System.in);
        if("add".equals(name)){
            System.out.print("Quote: ");
            String quote = input.nextLine();
            System.out.print("Author: ");
            String author = input.nextLine();
            System.out.print("Category: ");
            String category = input.nextLine();
            String formatQuote = quoteFormatter.formattedQuotes(quote, author, category, 0);
            add(quotes, formatQuote);
            System.out.println("Quote Added");
        }else if("modify".equals(name)){
            // todo
        }else if("delete".equals(name)){
            System.out.print("Quote: ");
            int index = input.nextInt();
        }
    }

    // Main Program
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
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
                    }else if(parameter.startsWith("db ")){
                        String name = parameter.substring("db ".length());
                        database(memorable, name);
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
