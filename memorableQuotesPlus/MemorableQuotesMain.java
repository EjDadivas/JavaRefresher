package memorableQuotesPlus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import memorableQuotesPlus.MemorableQuotesDatabase;

public class MemorableQuotesMain {
    private static String fileName = "C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotes\\quotes.txt";

    public static void main(String[] args) {
        
        MemorableQuotesDatabase random = new MemorableQuotesDatabase();
        System.out.println(random.getRandomQuote());

        MemorableQuote test1 = new MemorableQuote("test 2");
        random.addQuote(test1);
        random.removeQuote(test1);
        
        
        for(MemorableQuote i : random.getAllQuotes()){
            i.printQuote();
        }

        MemorableQuote x = random.getQuoteByIndex(1);
         x.printQuote();
        
        
    }
  
}
