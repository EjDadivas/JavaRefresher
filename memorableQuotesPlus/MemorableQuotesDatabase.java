package memorableQuotesPlus;

import java.util.ArrayList;
import java.util.Random;


public class MemorableQuotesDatabase {
    private ArrayList<MemorableQuote> quotes;
    private int count= 0;

    public MemorableQuotesDatabase() {
        quotes = new ArrayList<>();
        quotes.add(new MemorableQuote("The best way to predict the future is to invent it."));
        quotes.add(new MemorableQuote("Life is 10% what happens to us and 90% how we react to it."));
        quotes.add(new MemorableQuote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Test Reference"));
    
    }

    public ArrayList<MemorableQuote> getQuotes() {
        return this.quotes;
    }
    public String getRandomQuote() {
        Random ran = new Random();
        int n = ran.nextInt(quotes.size());
        return quotes.get(n).getQuoteText();

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

    public ArrayList<MemorableQuote> searchQuotes(String text){
        ArrayList<MemorableQuote> matchedQuotes = new ArrayList<>();
        for(MemorableQuote i : quotes){
            if(i.matches(text)){
                matchedQuotes.add(i);
            }
        }
        return(matchedQuotes);
    }
}
