package memorableQuotesPlus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MemorableQuotesDatabase {
    private ArrayList<MemorableQuote> quotes;
    // private String fileName = "C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotesPlus\\quotes.txt";

    public MemorableQuotesDatabase() {
        quotes = new ArrayList<>();
        quotes.add(new MemorableQuote("The best way to predict the future is to invent it.", "another Reference", "test"));
        quotes.add(new MemorableQuote("Life is 10% what happens to us and 90% how we react to it.", "test", "test"));
        quotes.add(new MemorableQuote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Test Reference", "eggs"));
        quotes.add(new MemorableQuote("Test quote", "tester", "eggs"));
    
    }

    public ArrayList<MemorableQuote> getQuotes() {
        return this.quotes;
    }
    public MemorableQuote getRandomQuote() {
        Random ran = new Random();
        int n = ran.nextInt(quotes.size());
        return quotes.get(n);

    }

    public void addQuote(MemorableQuote quote){
        quotes.add(quote);
    }

    public void removeQuote(MemorableQuote quote){
        quotes.remove(quote);
    }
 
    public MemorableQuote getQuoteByIndex(int n){
        return quotes.get(n);
    }

    public ArrayList<MemorableQuote> getAllQuotes(){
        return quotes;
    }

    public int getQuoteCount(){
        return quotes.size();
    }

    public ArrayList<MemorableQuote> searchQuotes(String text){
        ArrayList<MemorableQuote> matchedQuotes = new ArrayList<>();
        for(MemorableQuote i : quotes){
            if(i.matches(text)){
                System.out.println("matched");
                matchedQuotes.add(i);
            }
        }
        return(matchedQuotes);
    }

    public ArrayList<MemorableQuote> searchCategory(String text){
        ArrayList<MemorableQuote> matchedCategory = new ArrayList<>();
        for(MemorableQuote i : quotes){
            if(i.matchedCat(text)){
                matchedCategory.add(i);
            }
            else{
                System.out.println("unmatched");
            }
        }
        return(matchedCategory);
    }
    public boolean readFromFile(String filename){
        quotes = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filename));

            for (String line : allLines) {
                String[] split = line.split("@");
                quotes.add(new MemorableQuote(split[0], split[1], split[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean writeFromFile(String filename){
        return true;
    }
}
