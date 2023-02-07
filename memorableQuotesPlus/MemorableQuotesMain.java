package memorableQuotesPlus;
import java.util.ArrayList;
import java.util.Scanner;

public class MemorableQuotesMain {

    public static void main(String[] args) {
        MemorableQuotesDatabase quotesList = new MemorableQuotesDatabase();
        MemorableQuotesDisplayShow displayQuotesList = new MemorableQuotesDisplayShow(quotesList);
        
        while (true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose: [all/random/search]");
        String parameter = sc.nextLine();
        

        

        //add remove
        // MemorableQuote test1 = new MemorableQuote("test 2");
        // quotesList.addQuote(test1);
        // quotesList.removeQuote(test1);
        

        //quote by index
        // MemorableQuote x = quotesList.getQuoteByIndex(1);
        //  x.printQuote();
        
         //quote count
        // System.out.println(quotesList.getQuoteCount());
        
        

        if (quotesList.getQuoteCount() != 0) {
            //ALL
            if ("all".equals(parameter)) {
                //print all
                for(MemorableQuote i : quotesList.getAllQuotes()){
                    i.printQuote();
                }
            }else if (parameter.startsWith("all category=")) {
                String name = parameter.substring("all category=".length());
                //do the search here

                for(MemorableQuote item : quotesList.getAllQuotes()){
                    if (item.getCategory().contains(name)) {
                        item.printQuote();
                    } else {
                        System.out.println("No quotes in that category");
                    }
                }
            //RANDOM
            } else if ("random".equals(parameter)) {
                // random
                MemorableQuote random = quotesList.getRandomQuote();
                random.printQuote();
                
            } else if (parameter.startsWith("random category=")) {
                String name = parameter.substring("random category=".length());
                //do the search here
                System.out.println("search category: " + name);
                MemorableQuote random = quotesList.getRandomQuote();
                random.printQuote();

            //SEARCH
            } else if (parameter.startsWith("search ")) {
                String name = parameter.substring("search ".length());
                String[] split = name.split(" ");
                if(split.length == 2){
                    for (String i : split) {
                    if(i.contains("=")){
                    String[] splitCommand = i.split("=");
                        if("category".equals(splitCommand[0])){
                            //for the category search
                            ArrayList<MemorableQuote> x = quotesList.searchCategory(splitCommand[1]);
                            // for(MemorableQuote y : x){
                            //     y.printQuote();
                            // }
                            System.out.println("category: " + splitCommand[1]);
                            for(MemorableQuote item : quotesList.searchQuotes(name)){
                                System.out.println(item);
                                System.out.println(x);
                                if(x.contains(item)){
                                    item.printQuote();
                                    System.out.println("works");
                                }
                            }
                        } 
                    }
                }
            }
            for(MemorableQuote item : quotesList.searchQuotes(name)){
                item.printQuote();
            }
            //DISPLAY
            }else if("display".equals(parameter)){
                displayQuotesList.execute();
            } else if (parameter.startsWith("display ")) {
                String name = parameter.substring("display ".length());
                    String[] split = name.split(" ");
                    for (String i : split) {
                        String[] splitCommand = i.split("=");
                        if ("delay".equals(splitCommand[0])) {
                            displayQuotesList.setDelayBetweenQuotes(Integer.parseInt(splitCommand[1]));
                        } else if ("max".equals(splitCommand[0])) {
                            displayQuotesList.setMaxQuotesToDisplay(Integer.parseInt(splitCommand[1]));
                        } else if("category".equals(splitCommand[0])){
                            System.out.println("search category: " + splitCommand[0]);
                        }
                    }   
                displayQuotesList.execute();

            } else if ("quit".equals(parameter)) {
                break;
            } else {
                System.out.println("Invalid command");
            }

            } else {
                System.out.println("Error, No Quotes available");
                break;
            }
        }
        //end if statement
    
    }
}