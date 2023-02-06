package memorableQuotesPlus;

public class MemorableQuote {
    private String quoteText;
    private String reference;

    MemorableQuote(String quoteText){
        this.quoteText = quoteText;
    }

    MemorableQuote(String quoteText, String reference){
        this.quoteText = quoteText;
        this.reference = reference;
    }
    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText; 
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getQuoteText(){
        return quoteText;
    }
    public String getReference(){
        return reference;
    }
    public void printQuote(){
        if (reference == null) {
            System.out.println(quoteText);
        } else {
            System.out.println(quoteText + "\n -- " + reference);
        }
    }

    public boolean matches(String text){
        if(quoteText.toLowerCase().contains(text.toLowerCase()) || reference.toLowerCase().contains(text.toLowerCase())){
            return true;
        } else {
            return false;
        }
    }
}
