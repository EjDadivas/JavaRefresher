package memorableQuotesPlus;

public class MemorableQuote {
    private String quoteText;
    private String reference;
    private int counter = 0;

    // constructors
    MemorableQuote(String quoteText, String reference, String category, int counter) {
        this.quoteText = quoteText;
        this.reference = reference;
        this.category = category;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private String category;

    // Setters
    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getters
    public String getQuoteText() {
        return quoteText;
    }

    public String getReference() {
        return reference;
    }

    public String getCategory() {
        return category;
    }

    public void printQuote() {
        counter++;
        System.out.println(quoteText + " (" + counter + ")" + "\n -- " + reference + "|" + category + "\n");

    }

    public boolean matches(String text) {
        if (quoteText.toLowerCase().contains(text.toLowerCase())
                || reference.toLowerCase().contains(text.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchedCat(String text) {
        if (category.toLowerCase().equals(text.toLowerCase())) {
            return true;
        } else {
            return false;

        }
    }

}
