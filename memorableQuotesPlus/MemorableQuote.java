package memorableQuotesPlus;

import java.util.HashMap;
import java.util.Map;

public class MemorableQuote {
        //for the counter
    private static Map<String, Integer> count = new HashMap<>();
    private String quoteText;
    private String reference;
    private int counter=0;
    private String category;


    //constructors
    MemorableQuote(String quoteText, String reference, String category){
        this.quoteText = quoteText;
        this.reference = reference;
        this.category = category;
    }

    //Setters
    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText; 
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    //Getters
    public String getQuoteText(){
        return quoteText;
    }
    public String getReference(){
        return reference;
    }
    public String getCategory() {
        return category;
    }


    public void printQuote(){
        if (!count.containsKey(quoteText)) {
            // count.put(quoteText, Integer.parseInt(split[3]));
            count.put(quoteText, 0);

        }
        count.put(quoteText, count.get(quoteText) + 1);
        counter = count.get(quoteText);
        System.out.println(quoteText  + " (" + counter + ")" + "\n -- " + reference + "|" + category +"\n");
        
    }

    public boolean matches(String text){
        if(quoteText.toLowerCase().contains(text.toLowerCase()) || reference.toLowerCase().contains(text.toLowerCase())){
            return true;
        } else{
        return false;
        }
    }
    public boolean matchedCat(String text){
        if(category.toLowerCase().equals(text.toLowerCase())){
            return true;
        } else {
            System.out.println("not found: " + text);
            return false;
            
        }
    }

}
